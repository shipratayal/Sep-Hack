package com.nexthoughts.issuetracker.enums

enum IssueStatus {
    OPEN("Open"),
    CLOSED("Closed")

    String value

    IssueStatus(String value) {
        this.value = value
    }

    String value() {
        return value
    }
}