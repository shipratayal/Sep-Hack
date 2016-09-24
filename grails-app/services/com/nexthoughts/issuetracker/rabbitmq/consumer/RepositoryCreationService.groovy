package com.nexthoughts.issuetracker.rabbitmq.consumer

import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryAddMessage
import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class RepositoryCreationService {

    def rabbitMqEmailService
    def prettyExceptionService

    static rabbitSubscribe = [name: "email", routingKey: "email.repository.creation"]

    @NotTransactional
    void handleMessage(RepositoryAddMessage message) {
        println message.properties
        try {
            rabbitMqEmailService.sendRepositoryCreationMail(message)
        } catch (Exception e) {
            prettyExceptionService.flush("Exception while sending repository creation mail", e)
            println "Handling exception at consumer"
        }
    }
}
