package com

import com.nexthoughts.issuetracker.rabbitmq.messages.IssueOpenedMessage
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryDeletedMessage

class MailCO {

    String from = "testing@sparkpostbox.com"
    List<String> to
    String viewFileName
    Map modelMap
    String subject
    User createdBy

    MailCO(){}

    MailCO(RepositoryDeletedMessage message) {
        this.to = [message?.ownerUserName]
        this.viewFileName = "/emailTemplates/repositoryDeletionMail"
        this.subject = "Repository Successfully deleted"
        this.modelMap = [firstName: message?.firstName, repositoryName: message?.repositoryName]
        this.createdBy = message?.user
    }

    MailCO(IssueOpenedMessage message, String to){
        this.to = [to]
        this.viewFileName = "/test"
        this.subject = "New Issue Created"
        this.modelMap = [mail:message]
        this.createdBy = message?.createdBy
    }
}
