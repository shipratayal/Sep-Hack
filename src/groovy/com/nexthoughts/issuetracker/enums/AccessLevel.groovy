package com.nexthoughts.issuetracker.enums

enum AccessLevel {

    PUBLIC("Public"),
    PRIVATE("Private")

    String value

    AccessLevel(String value) {
        this.value = value
    }

    String value() {
        return value
    }
}