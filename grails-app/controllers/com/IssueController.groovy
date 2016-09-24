package com

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class IssueController {

    def createIssue() {
        render(view: 'create')
    }

    def submitIssue() {
        CommonsMultipartFile addressProof = params.addressproof
    }
}