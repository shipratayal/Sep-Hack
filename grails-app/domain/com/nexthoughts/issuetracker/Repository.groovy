package com.nexthoughts.issuetracker

import com.User
import com.nexthoughts.issuetracker.enums.AccessLevel
import com.nexthoughts.issuetracker.enums.ObjectStatus

class Repository {

    String name
    String description
    AccessLevel accessLevel = AccessLevel.PUBLIC
    String uniqueId = UUID.randomUUID().toString()
    ObjectStatus objectStatus = ObjectStatus.CURRENT
    Boolean isDeleted = Boolean.FALSE
    Date dateCreated
    Date lastUpdated
    User owner

    static hasMany = [teams: Team]

    static constraints = {
        name blank: false
        description blank: false, minSize: 20, maxSize: 500
    }

    static mapping = {
        description sqlType: 'text'
    }
}
