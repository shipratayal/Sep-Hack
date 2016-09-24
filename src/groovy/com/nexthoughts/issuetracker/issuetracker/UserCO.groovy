package com.nexthoughts.issuetracker.issuetracker

import grails.validation.Validateable

@Validateable
class UserCO {
    String username
    String password
    String confirmPassword
    String firstName
    String lastName
    String profile

    static constraints = {
        username blank: false, nullable: false
        password blank: false, nullable: false
        confirmPassword nullable: false, validator: { confirm, obj ->
            if (!confirm.equals(obj.password)) {
                return false
            }
        }
        firstName blank: false, nullable: false
        lastName blank: false, nullable: false
        profile blank: false, nullable: false

    }
}
