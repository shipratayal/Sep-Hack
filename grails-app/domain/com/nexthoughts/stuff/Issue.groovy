package com.nexthoughts.stuff

import com.User
import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.enums.IssueStatus
import com.nexthoughts.issuetracker.enums.ObjectStatus

class Issue {
    String title
    String description
    User createdBy
    Date dateCreated
    Date lastUpdated
    String uniqueId = UUID.randomUUID().toString()
    IssueStatus issueStatus = IssueStatus.OPEN
    ObjectStatus objectStatus = ObjectStatus.CURRENT
    Boolean isDeleted = Boolean.FALSE
    MileStone mileStone

    static belongsTo = [project: Repository]
    static hasMany = [attachments: Attachments, comments: Comment, labels: Label, assignees: User]
    static constraints = {
        title nullable: false, blank: false
        description nullable: true, false: true
        mileStone nullable: true
    }

    static mapping = {
        description sqlType: 'text'
    }
}
