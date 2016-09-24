package com.nexthoughts.issuetracker.rabbitmq.messages

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.notification.Notification


class RepositoryAddMessage implements Serializable {

    Long repositoryId
    Long notificationId

    RepositoryAddMessage(Repository repository) {
        println "creating repository message"
        this.repositoryId = repository?.id
    }

    RepositoryAddMessage(Notification notification) {
        println "creating repository message"
        this.repositoryId = notification?.id
    }

    RepositoryAddMessage(Repository repository, Notification notification) {
        println "creating repository message"
        this.repositoryId = repository?.id
        this.notificationId = notification?.id
    }
}
