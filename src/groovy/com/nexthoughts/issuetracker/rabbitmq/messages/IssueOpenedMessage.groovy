package com.nexthoughts.issuetracker.rabbitmq.messages

import com.User
import com.nexthoughts.stuff.Issue

/**
 * Created by nakul on 24/9/16.
 */
class IssueOpenedMessage {
    Long issueId
    String title
    User createdBy
    List<String> toList

    IssueOpenedMessage(Issue issue, List<String> sendersList) {
        this.issueId = issue?.id
        this.title = issue?.title
        this.createdBy = issue?.createdBy
        this.toList = sendersList
    }
}
