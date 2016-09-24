package com.nexthoughts.issuetracker.rabbitmq.consumer

import com.nexthoughts.issuetracker.rabbitmq.messages.SignUpMailMessage
import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class SignupMailService {

    def rabbitMqEmailService
    def prettyExceptionService

    static rabbitSubscribe = [name: "email", routingKey: "email.signup"]

    @NotTransactional
    void handleMessage(SignUpMailMessage message) {
        println message.properties
        try {
            rabbitMqEmailService.sendSignupMail(message)
        } catch (Exception e) {
            prettyExceptionService.flush("Exception while sending signup mail", e)
            println "Handling exception at consumer"
        }
    }
}
