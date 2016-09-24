package com

import grails.plugin.springsecurity.annotation.Secured

//@Secured(['ROLE_ADMIN', 'ROLE_USER'])
@Secured("permitAll")
class UserController {

    def dashboard() {
        render(view: 'dashboard')
    }
}