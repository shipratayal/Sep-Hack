package com

import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryDeletedMessage

class MailCO {

    String from = "testing@sparkpostbox.com"
    List<String> to
    String viewFileName
    Map modelMap
    String subject

    MailCO(RepositoryDeletedMessage message) {
        this.to = message?.ownerUserName
        this.viewFileName = "/emailTemplates/repositoryDeletionMail"
        this.subject = "Repository Successfully deleted"
        this.modelMap = [firstName: message?.firstName, repositoryName: message?.repositoryName]
    }
}
