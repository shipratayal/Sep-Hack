package com.nexthoughts.stuff

import com.User

class Comment {
    String description
    User commentedBy

    static hasMany = [attachments: Attachments, notifies: User]
    static constraints = {
        description nullable: false, blank: false
        commentedBy nullable: false
    }
    static mapping = {
        description sqlType: 'longtext'
    }
}
