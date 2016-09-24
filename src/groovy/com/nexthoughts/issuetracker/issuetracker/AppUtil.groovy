package com.nexthoughts.issuetracker.issuetracker

import com.User
import com.nexthoughts.issuetracker.Repository


class AppUtil {

    static Boolean save(def object) {
        Boolean result = false
        if (object.validate() && !object.hasErrors() && object.save(flush: true)) {
            result = true
        } else {
            object.errors.allErrors.each {
                println '----------------------' + it

            }
            result = false

        }
        return result
    }

    public static List<User> getTeamMembersByRepository(def repositoryId) {
        Set<User> userSet = []
        Repository.get(repositoryId as Long)?.teams?.each {
            it.members?.each { User user ->
                userSet.add(user)
            }
        }
        userSet.asList()
    }
}
