package com

import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryDeletedMessage

class MailCO {

    String from = "testing@sparkpostbox.com"
    List<String> to
    String viewFileName
    Map modelMap
    String subject
    User createdBy

    MailCO(){}

    MailCO(RepositoryDeletedMessage message, User user) {
        this.to = message?.ownerUserName
        this.viewFileName = "/emailTemplates/repositoryDeletionMail"
        this.subject = "Repository Successfully deleted"
        this.modelMap = [firstName: message?.firstName, repositoryName: message?.repositoryName]
        this.createdBy = user
    }
}
