package com.nexthoughts.issuetracker.rabbitmq.messages

import com.User
import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.notification.Notification

class RepositoryDeletedMessage implements Serializable {
    String firstName
    String ownerUserName
    String repositoryName
    User user
    Long notificationId

    RepositoryDeletedMessage(Repository repository, User user) {
        this.firstName = repository?.owner?.firstName
        this.ownerUserName = repository?.owner?.username
        this.repositoryName = repository?.name
        this.user = user
    }

    RepositoryDeletedMessage(Notification notification, User user) {
        this.notificationId = notification.id
        this.user = user
    }

    RepositoryDeletedMessage(Repository repository, Notification notification, User user) {
        this.firstName = repository?.owner?.firstName
        this.ownerUserName = repository?.owner?.username
        this.repositoryName = repository?.name
        this.notificationId = notification.id
        this.user = user
    }
}
