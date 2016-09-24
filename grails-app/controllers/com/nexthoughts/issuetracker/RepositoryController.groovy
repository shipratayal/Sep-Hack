package com.nexthoughts.issuetracker

import com.User
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryAddMessage
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryDeletedMessage
import com.nexthoughts.stuff.Issue
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
@Transactional(readOnly = true)
class RepositoryController {

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(params.max ?: 10, 100)
        respond Repository.list(params), model: [repositoryInstanceCount: Repository.count()]
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

        /*repositoryInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'repository.label', default: 'Repository'), repositoryInstance.id])
                redirect repositoryInstance
            }
            '*' { respond repositoryInstance, [status: CREATED] }
        }*/
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
        Long id = params?.repoId as Long
        Repository repositoryInstance = Repository.get(id as Long)
        RepositoryDeletedMessage message = new RepositoryDeletedMessage(repositoryInstance)
        if (/*repositoryInstance.delete(flush: true)*/ true) {
//TODO:Add rabbitmq send here rabbit
            rabbitMqEmailService.sendRepositoryDeletionMail(message)
            flash.success = "Repository has been successfully deleted"
            redirect action: "index"
        } else {
            flash.error = "Repository could not be deleted"
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

    def showTickets() {
        println("========= repositoryId = " + params.id)
        Long repositoryId = params.id as Long
        Repository repository = Repository.get(repositoryId)
        List<Issue> issues = Issue.findAllByProject(repository)
        render(view: 'dashboard', model: [repositoryId: repositoryId, issues: issues])
    }
}
