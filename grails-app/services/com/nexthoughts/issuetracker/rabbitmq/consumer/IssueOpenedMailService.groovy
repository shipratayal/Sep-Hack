package com.nexthoughts.issuetracker.rabbitmq.consumer

import com.nexthoughts.issuetracker.rabbitmq.messages.IssueOpenedMessage
import com.nexthoughts.issuetracker.rabbitmq.messages.SignUpMailMessage
import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class IssueOpenedMailService {

    def rabbitMqEmailService
    def prettyExceptionService

    static rabbitSubscribe = [name: "email", routingKey: "email.issue"]

    @NotTransactional
    void handleMessage(IssueOpenedMessage message) {
        println message.properties
        try {
            rabbitMqEmailService.sendSignupMail(message)
        } catch (Exception e) {
            prettyExceptionService.flush("Exception while sending signup mail", e)
            println "Handling exception at consumer"
        }
    }
}
