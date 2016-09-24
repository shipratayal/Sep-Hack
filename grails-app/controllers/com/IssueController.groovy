package com

import com.nexthoughts.issuetracker.issuetracker.IssueCO
import grails.plugin.springsecurity.annotation.Secured
import issuetracker.IssueService
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class IssueController {

    IssueService issueService

    def createIssue() {
        println("=========== create issue action id = "+params.repositoryId)
        render(view: 'create',model: [repositoryId : params.repositoryId])
    }

    def submitIssue = { IssueCO issueCO ->
        println("========== submit Issue id = "+params.repositoryId)
        issueService.saveIssue(issueCO)
//        here call the method to send notification asynchronously
        redirect(controller: 'repository' , action: 'showTickets' , params: [id: issueCO.repositoryId])
    }
}