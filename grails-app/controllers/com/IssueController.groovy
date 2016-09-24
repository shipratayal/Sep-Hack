package com

import com.nexthoughts.issuetracker.issuetracker.IssueCO
import grails.plugin.springsecurity.annotation.Secured
import issuetracker.IssueService
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class IssueController {

    IssueService issueService

    def createIssue() {
        render(view: 'create')
    }

    def submitIssue = { IssueCO issueCO ->

        issueService.saveIssue(issueCO)
//        println("========== Submit Issue Action ===========")
//        println("===== Title = "+params.title)
//        println("===== Description = "+params.editor1)
//        println("===== labels = "+params.list("labels"))
//        println("===== milestone = "+params.list("milestone"))
//        println("===== authors = "+params.list("authors"))


        render "succeessfull"
    }
}