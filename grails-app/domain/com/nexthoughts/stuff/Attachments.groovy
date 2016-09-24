package com.nexthoughts.stuff

import com.nexthoughts.issuetracker.enums.ObjectStatus

class Attachments {

    String attachmentName
    String attachmentPathName
    String attachmentContentType
    Comment comment
    Date dateCreated
    Date lastUpdated
    ObjectStatus objectStatus = ObjectStatus.CURRENT
    Boolean isDeleted = Boolean.FALSE

    static belongsTo = [issue: Issue]

    static constraints = {
        attachmentPathName(nullable: true)
        attachmentName(nullable: true)
        attachmentContentType(nullable: true)
        comment nullable: true
    }
}
