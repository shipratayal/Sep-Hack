package com.nexthoughts.issuetracker.rabbitmq.messages

import com.User
import com.nexthoughts.issuetracker.Repository

class RepositoryDeletedMessage implements Serializable {
    String firstName
    String ownerUserName
    String repositoryName
    User user

    RepositoryDeletedMessage(Repository repository,User user) {
        this.firstName = repository?.owner?.firstName
        this.ownerUserName = repository?.owner?.username
        this.repositoryName = repository?.name
        this.user=user
    }
}
