package com.nexthoughts.issuetracker.enums

enum NotificationType {
    ISSUE_CREATE("Issue Create"),
    ISSUE_DELETE("Issue Delete"),
    MILESTONE("Milestone"),
    LABEL("Label"),
    COMMENTS("Comments"),
    REPOSITORY_CREATE("Repository Create"),
    REPOSITORY_DELETE("Repository Delete")

    String value

    NotificationType(String value) {
        this.value = value
    }

    String value() {
        return value
    }
}