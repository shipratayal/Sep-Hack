package com

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.issuetracker.AppUtil
import com.nexthoughts.issuetracker.issuetracker.UserCO
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class UserController {

    def springSecurityService

    def dashboard() {
        User user = springSecurityService.currentUser
        params.max = Math.min(params.max ?: 10, 100)
        render(view: 'dashboard', model: [user: user,repositoryInstanceList: Repository.list(params), repositoryInstanceCount: Repository.count()])
    }


    def create(UserCO userCO) {
        Role role = Role.findByAuthority("ROLE_USER")
        if (userCO.validate()) {
            User user = new User(userCO)
            AppUtil.save(user)
            UserRole userRole = new UserRole(role: role, user: user)
            if (AppUtil.save(userRole))
                render(view: '/index')
        } else {
            render(view: '/signUp')
        }

    }

//    def update(UserCO userCO) {
//        if (userCO.validate()) {
//            User user = User.findById()
//            user.firstName = userCO.firstName
//            user.lastName = userCO.lastName
//            user.profile = userCO.profile
//            user.password = userCO.password
//            AppUtil.save(user)
//        }
//    }
//
//    def delete() {
//        User user = User.findById()
//        user.delete()
//        Role role = Role.findByAuthority("ROLE_USER")
//        UserRole userRole = new UserRole(role: role, user: user)
//        userRole.delete()
//
//    }

    def list() {
        render(view: '/repository/list', model: [userList: User.list()])
    }
}