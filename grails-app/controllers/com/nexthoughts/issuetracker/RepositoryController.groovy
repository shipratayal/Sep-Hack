package com.nexthoughts.issuetracker

import com.User
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryAddMessage
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryDeletedMessage
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
@Transactional(readOnly = true)
class RepositoryController {
    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "GET"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        User user = springSecurityService.currentUser
        params.max = Math.min(params.max ?: 10, 100)
        List<Repository> repositoryList = Repository.list(params)
        println repositoryList
        List<Repository> notDeletedList = []
        notDeletedList = repositoryList?.findAll { !it.isDeleted && it.owner == user }
        println notDeletedList
        respond notDeletedList, model: [repositoryInstanceCount: Repository.count(), user: user]
    }

    def create() {
        respond new Repository(params)
    }

    @Transactional
    def save(Repository repositoryInstance) {
        repositoryInstance.clearErrors()
        User currentUser = springSecurityService.currentUser as User
        repositoryInstance?.owner = currentUser

        if (repositoryInstance == null) {
            notFound()
            return
        }
        repositoryInstance.validate()
        if (repositoryInstance.hasErrors()) {
            respond repositoryInstance.errors, view: 'create'
            return
        } else {
            Repository repository = new Repository(repositoryInstance).save(flush: true)
            if (repository) {
                RepositoryAddMessage message = new RepositoryAddMessage(repository)
                rabbitSend "email", "email.repository.creation", message
                flash.success = "Repository created successfully"
                redirect action: "index"
            } else {
                flash.error = "Repository couldnot be saved, Please try again"
                redirect action: "create"
            }
        }
    }

    def edit(Repository repositoryInstance) {
        respond repositoryInstance
    }

    @Transactional
    def update(Repository repositoryInstance) {
        if (repositoryInstance == null) {
            notFound()
            return
        }

        if (repositoryInstance.hasErrors()) {
            respond repositoryInstance.errors, view: 'edit'
            return
        }

        repositoryInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Repository.label', default: 'Repository'), repositoryInstance.id])
                redirect repositoryInstance
            }
            '*' { respond repositoryInstance, [status: OK] }
        }
    }

    def rabbitMqEmailService

    @Transactional
    def delete(Long repoId) {
        User user = springSecurityService.currentUser as User
        Long id = params?.repoId as Long
        Repository repositoryInstance = Repository.get(id as Long)

        if (user.username == repositoryInstance?.owner?.username) {
            RepositoryDeletedMessage message = new RepositoryDeletedMessage(repositoryInstance, user)
            repositoryInstance.isDeleted = Boolean.TRUE
            if (repositoryInstance.save(flush: true)) {
                rabbitSend "email", "email.repository.deletion", message
                flash.success = "Repository has been successfully deleted"
                redirect action: "index"
            } else {
                flash.error = "Repository could not be deleted"
                redirect action: "index"
            }
        } else {
            flash.error = "Repository can be deleted only by the owner "
            redirect action: "index"
        }

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'repository.label', default: 'Repository'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def filter() {
        params.max = Math.min(params.max ?: 10, 100)
        render(template: 'repositoryFilter', model: [repositoryInstanceCount: Repository.count(), repositoryInstanceList: Repository.list(params)])
    }
}
