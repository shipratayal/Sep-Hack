package com

import grails.plugin.springsecurity.annotation.Secured

@Secured("permitAll")
class PublicController {
    def springSecurityService

    def index() {
        User user = springSecurityService.currentUser
        List<Role> roles = user?.getAuthorities()?.toList()
        if (roles?.authority?.contains("ROLE_USER")) {
            redirect(controller: "user", action: "dashboard")
        } else if (roles?.authority?.contains("ROLE_ADMIN")) {
            redirect(controller: "user", action: "dashboard")
        } else {
            render(view: '/index')
        }
    }
}