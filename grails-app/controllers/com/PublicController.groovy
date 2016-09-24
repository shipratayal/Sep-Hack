package com

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.issuetracker.AppUtil
import com.nexthoughts.issuetracker.issuetracker.UserCO
import com.nexthoughts.issuetracker.rabbitmq.messages.SignUpMailMessage
import grails.plugin.springsecurity.annotation.Secured

@Secured("permitAll")
class PublicController {
    def springSecurityService
    def rabbitMqEmailService

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
            flash.error = "User is already registered with the entered email address"
            render(view: '/signUp')
        } else {
            if (userCO.validate()) {
                User user = new User(userCO)
                AppUtil.save(user)
                UserRole userRole = new UserRole(role: role, user: user)
                if (AppUtil.save(userRole)) {
                    SignUpMailMessage message = new SignUpMailMessage(userId: user?.id)
                    rabbitSend "email", "email.signup", message
                    flash.success = "Your account has been successfully created"
                    render(view: '/index')
                } else {
                    flash.error = "Your account has not been created"
                    render(view: '/signUp')
                }
            } else {
                flash.error = "Your account has not been created"
                render(view: '/signUp')
            }
        }
    }

    def test() {
        Repository repository = Repository.get(1 as Long)
        render view: "/test", model: [repository: repository]
    }
}