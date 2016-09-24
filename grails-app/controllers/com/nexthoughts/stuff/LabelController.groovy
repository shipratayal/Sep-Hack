package com.nexthoughts.stuff

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.issuetracker.AppUtil
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class LabelController {

    def index() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        render(view: 'index', model: [labelInstanceList: Label.list(max: params.int('max'), offset: 0), labelInstanceTotal: Label.count(), repositoryId: params.repositoryId])
    }

    def filter() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        render(template: 'labelFilter', model: [labelInstanceList: Label.list(max: params.int('max'), offset: 0), labelInstanceTotal: Label.count()])
    }

    def createLabel() {
        render(view: 'createLabel', model: [repositoryId : params.repositoryId])
    }

    def saveLabel() {
        String label = params.labelName
        Label label1 = new Label()
        label1.title = label
        label1.color = params.color
        Repository repository = Repository.get(params.repositoryId)
        label1.repository = repository
        AppUtil.save(label1)
        redirect(action: 'index' , params: [repositoryId: params.repositoryId])
    }

    def deleteLabel = {
        Label label = Label.get(params.labelId)
        label.delete(flush: true)
        redirect(action: 'index', params: [repositoryId : params.repositoryId])
    }

    def updateLabel() {
        Label label = Label.get(params.labelId)
        label.title = params.labelName
        label.color = params.labelColor
        AppUtil.save(label)
        redirect(action: 'index', params: [repositoryId : params.repositoryId])
    }
}
