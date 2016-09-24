package com.nexthoughts.issuetracker.enums

enum TeamProfile {

    TESTER("Tester"), DEVELOPER("Developer"), BIG_DATA("Big Date"), MOBILITY("Mobility")
    String value

    TeamProfile(String value) {
        this.value = value
    }

    String value() {
        return value
    }
}