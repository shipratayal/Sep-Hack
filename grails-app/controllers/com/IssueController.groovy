package com

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.issuetracker.IssueCO
import com.nexthoughts.stuff.Issue
import grails.plugin.springsecurity.annotation.Secured
import issuetracker.IssueService

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class IssueController {

    IssueService issueService

    def createIssue() {
        println("=========== create issue action id = " + params.repositoryId)
        render(view: 'create', model: [repositoryId: params.repositoryId])
    }

    def submitIssue = { IssueCO issueCO ->
        println("========== submit Issue id = " + params.repositoryId)
        issueService.saveIssue(issueCO)
        redirect(controller: 'issue', action: 'showTickets', params: [id: issueCO.repositoryId])
    }

    def showTickets(Long id) {
        Repository repository = Repository.get(id)
        List<Issue> issues = Issue.findAllByProject(repository)
        render(view: 'dashboard', model: [repositoryId: id, issues: issues])
    }

    def updateTickets(Long id) {
        Repository repository = Repository.get(id)
        List<Issue> issues = Issue.findAllByProject(repository)
        render(view: 'dashboard', model: [repositoryId: id, issues: issues])
    }

    def edit(Long id) {
        Issue issue = Issue.get(id)
        render(view: 'edit', model: [issue: issue])
    }

    def index(Long id) {
        Issue issue = Issue.get(id)
        render(view: 'index', model: [issue: issue])
    }
}