package com.nexthoughts.notification

import com.User
import com.nexthoughts.issuetracker.enums.NotificationStatus
import com.nexthoughts.issuetracker.enums.NotificationType

class Notification {
    String uniqueId = UUID.randomUUID().toString()
    NotificationStatus status = NotificationStatus.PENDING
    NotificationType type
    User createdBy
    Date dateCreated
    Date lastUpdated
    static hasMany = [notifyTo: User, readBy: User]

    static constraints = {
        status nullable: false
        type nullable: false
        createdBy nullable: false
    }
}