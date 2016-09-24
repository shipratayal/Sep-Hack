package com.nexthoughts.issuetracker.enums

enum ObjectStatus {
    OLD("Old"), CURRENT("Current")

    String value

    ObjectStatus(String value) {
        this.value = value
    }

    String value() {
        return value
    }
}