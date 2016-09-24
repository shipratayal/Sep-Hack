package com

import com.nexthoughts.issuetracker.issuetracker.AppUtil
import com.nexthoughts.issuetracker.issuetracker.UserCO
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

    def signUp() {
        render(view: '/signUp')
    }

    def register(UserCO userCO) {
        Role role = Role.findByAuthority("ROLE_USER")
        if (User.list().username.contains(userCO.username)) {
            flash.message = "User Name already exist"
            render(view: '/signUp')
        } else {
            if (userCO.validate()) {
                User user = new User(userCO)
                AppUtil.save(user)
                UserRole userRole = new UserRole(role: role, user: user)
                AppUtil.save(userRole)
                flash.message = "Success"
                render(view: '/index')
            } else {
                flash.message = "Wrong Credentials"
                render(view: '/signUp')
            }
        }

    }
}