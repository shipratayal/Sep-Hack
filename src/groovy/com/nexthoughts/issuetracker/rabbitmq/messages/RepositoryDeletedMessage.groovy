package com.nexthoughts.issuetracker.rabbitmq.messages

import com.nexthoughts.issuetracker.Repository

class RepositoryDeletedMessage implements Serializable {
    String firstName
    String ownerUserName
    String repositoryName

    RepositoryDeletedMessage(Repository repository) {
        this.firstName = repository?.owner?.firstName
        this.ownerUserName = repository?.owner?.username
        this.repositoryName = repository?.name
    }
}
