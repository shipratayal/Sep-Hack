package com.nexthoughts.issuetracker

import com.User
import com.nexthoughts.issuetracker.enums.ObjectStatus
import com.nexthoughts.issuetracker.enums.TeamProfile

class Team {

    String name
    TeamProfile teamProfile
    String uniqueId = UUID.randomUUID().toString()
    ObjectStatus objectStatus = ObjectStatus.CURRENT
    Boolean isDeleted = Boolean.FALSE
    Date dateCreated
    Date lastUpdated

    static belongsTo = Repository
    static hasMany = [members: User, repositories: Repository]

    static constraints = {
        name blank: false, minSize: 3, maxSize: 20
    }
}
