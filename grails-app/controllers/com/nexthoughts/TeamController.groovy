package com.nexthoughts

import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class TeamController {

    def createTeam = {
        render view: 'createTeam'
    }
}
