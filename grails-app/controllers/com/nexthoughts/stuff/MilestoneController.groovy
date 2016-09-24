package com.nexthoughts.stuff

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.issuetracker.AppUtil
import grails.plugin.springsecurity.annotation.Secured

import java.text.SimpleDateFormat

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class MilestoneController {

    def index() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        render(view: 'index', model: [milestoneInstanceList: MileStone.list(max: params.int('max'), offset: 0), milestoneInstanceTotal: MileStone.count(), repositoryId: params.repositoryId])
    }

    def createMilestone() {
        render(view: 'createMilestone', model: [repositoryId: params.repositoryId])
    }

    def saveMilestone() {
        MileStone mileStone = new MileStone()
        mileStone.title = params.milestoneName
        mileStone.description = params.description
        String date = params.dueDate
        println("===============DATE=======${date}")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy")
        mileStone.dueDate = simpleDateFormat.parse(date)
        Issue issue = Issue.findById(params.issue)
        mileStone.addToIssues(issue)
        Repository repository = Repository.get(params.repositoryId)
        mileStone.repository = repository
        AppUtil.save(mileStone)
        redirect(action: 'index', params: [repositoryId: params.repositoryId])
    }

}
