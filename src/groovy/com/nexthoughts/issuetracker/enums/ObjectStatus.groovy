package com.nexthoughts.issuetracker.enums

/**
 * Created by nakul on 24/9/16.
 */
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