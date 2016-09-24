package com.nexthoughts.issuetracker.rabbitmq.consumer

import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryAddMessage
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryDeletedMessage
import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class RepositoryDeletionService {

    def rabbitMqEmailService
    def prettyExceptionService

    static rabbitSubscribe = [name: "email", routingKey: "email.repository.deletion"]

    @NotTransactional
    void handleMessage(RepositoryDeletedMessage message) {
        println message.properties
        try {
            rabbitMqEmailService.sendRepositoryDeletionMail(message)
        } catch (Exception e) {
            prettyExceptionService.flush("Exception while sending repository creation mail", e)
            println "Handling exception at consumer"
        }
    }
}
