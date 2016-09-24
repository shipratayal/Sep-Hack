package com

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class UserController {

    def dashboard() {
        render(view: 'dashboard')
    }
}