package com.nexthoughts.issuetracker.enums

enum NotificationType {
    ISSUE("Issue"),
    MILESTONE("Milestone"),
    LABEL("Label"),
    COMMENTS("Comments"),
    REPOSITORY("Email")

    String value

    NotificationType(String value) {
        this.value = value
    }

    String value() {
        return value
    }
}