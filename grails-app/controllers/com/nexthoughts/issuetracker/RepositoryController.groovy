package com.nexthoughts.issuetracker

import com.User
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryAddMessage
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
@Transactional(readOnly = true)
class RepositoryController {

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Repository.list(params), model: [repositoryInstanceCount: Repository.count()]
    }

    def show(Repository repositoryInstance) {
        redirect(action: 'index')
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
        }else{
            Repository repository = new Repository(repositoryInstance).save(flush: true)
            if(repository){
                RepositoryAddMessage message = new RepositoryAddMessage(repository)
                rabbitSend "email", "email.repository.creation", message
                flash.success="Repository created successfully"
                redirect action:"index"
            }else{
                flash.error="Repository couldnot be saved, Please try again"
                redirect action: "create"
            }
        }

        /*request.withFormat {
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

    @Transactional
    def delete(Repository repositoryInstance) {

        if (repositoryInstance == null) {
            notFound()
            return
        }

        repositoryInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Repository.label', default: 'Repository'), repositoryInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
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
}
