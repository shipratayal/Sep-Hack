package com.nexthoughts.issuetracker.enums

enum NotificationStatus {
    SENT("Sent"),
    PENDING("Pending")

    String value

    NotificationStatus(String value) {
        this.value = value
    }

    String value() {
        return value
    }
}