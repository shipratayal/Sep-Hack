package com

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.issuetracker.UserCO
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService

    String username
    String password
    String firstName
    String lastName
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    User(String username, String password) {
        this()
        this.username = username
        this.password = password
    }

    User(UserCO userCO) {
        this()
        this.username = userCO.username
        this.password = userCO.password
        this.firstName = userCO.firstName
        this.lastName = userCO.lastName
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this)*.role
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static transients = ['springSecurityService']

    static constraints = {
        username blank: false, unique: true
        password blank: false
        firstName blank: false, minSize: 4, maxSize: 12
        lastName blank: false, minSize: 4, maxSize: 12
    }

    static mapping = {
        password column: '`password`'
    }

    static hasMany = [repositories: Repository]
}
