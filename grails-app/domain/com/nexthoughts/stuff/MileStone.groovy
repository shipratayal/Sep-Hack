package com.nexthoughts.stuff

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.enums.ObjectStatus

class MileStone {

    String title
    String description
    Date dateCreated
    Date lastUpdated
    Date dueDate
    ObjectStatus objectStatus = ObjectStatus.CURRENT
    Boolean isDeleted = Boolean.FALSE
    static belongsTo = [repository: Repository]
    static hasMany = [issues: Issue]

    static constraints = {
        title nullable: false, blank: false
        description nullable: true, false: true
        dueDate nullable: false
    }
}
