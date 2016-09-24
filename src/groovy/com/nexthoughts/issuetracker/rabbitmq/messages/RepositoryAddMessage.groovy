package com.nexthoughts.issuetracker.rabbitmq.messages

import com.nexthoughts.issuetracker.Repository


class RepositoryAddMessage implements Serializable{

    Long repositoryId

    RepositoryAddMessage(Repository repository) {
        println "creating repository message"
        this.repositoryId = repository?.id
    }
}
