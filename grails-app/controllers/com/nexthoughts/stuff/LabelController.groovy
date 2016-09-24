package com.nexthoughts.stuff

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class LabelController {

    def index() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        render(view: 'index', model: [labelInstanceList: Label.list(max: params.int('max'), offset: 0), labelInstanceTotal: Label.count()])
    }

    def filter() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        render(template: 'labelFilter', model: [labelInstanceList: Label.list(max: params.int('max'), offset: 0), labelInstanceTotal: Label.count()])
    }

    def createLabel() {
        render(view: 'createLabel')
    }

    def saveLabel() {

    }

    def deleteLabel(int id) {

    }

    def updateLabel() {

    }
}
