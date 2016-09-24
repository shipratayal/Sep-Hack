package com.nexthoughts.issuetracker

import com.Role
import com.User
import com.UserRole
import com.nexthoughts.issuetracker.issuetracker.AppUtil
import com.nexthoughts.issuetracker.issuetracker.UserCO

class UserController {

    def create(UserCO userCO) {
        Role role = Role.findByAuthority("ROLE_USER")
        if (userCO.validate()) {
            User user = new User(userCO)
            AppUtil.save(user)
            UserRole userRole = new UserRole(role: role, user: user)
            AppUtil.save(userRole)
            render(view: '')
        } else {
            render(view: '/')
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

    def signUp = {
        render(view: '/signUp')
    }
}
