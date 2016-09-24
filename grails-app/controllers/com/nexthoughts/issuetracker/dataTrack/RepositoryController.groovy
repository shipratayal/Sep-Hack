package com.nexthoughts.issuetracker.dataTrack

import com.nexthoughts.issuetracker.Repository
import grails.plugin.springsecurity.annotation.Secured

class RepositoryController {

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list() {
        render(view:'list',model:[repoList:Repository.list()])
    }
}
