package issuetracker

import com.User
import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.issuetracker.AppUtil
import com.nexthoughts.issuetracker.issuetracker.IssueCO
import com.nexthoughts.issuetracker.rabbitmq.messages.IssueOpenedMessage
import com.nexthoughts.stuff.Issue
import com.nexthoughts.stuff.Label
import com.nexthoughts.stuff.MileStone
import grails.plugin.springsecurity.SpringSecurityService

class IssueService {

    SpringSecurityService springSecurityService

    boolean saveIssue(IssueCO issueCO) {

        println("===== Repository id = " + issueCO.repositoryId)
        println("====== Title = " + issueCO.title)

        Issue issue = new Issue()
        issue.title = issueCO.title
        issue.description = issueCO.editor1
        issue.createdBy = springSecurityService.currentUser
        if (issueCO?.milestone && !issueCO?.milestone.equals("null")) {
            issue.mileStone = MileStone.get(issueCO?.milestone as Long)
        }
        if (!issueCO?.labels) {
            issueCO.labels.each {
                issue.addToLabels(Label.get(it))
            }
        }
        if (!issueCO?.authors) {
            issueCO.authors.each {
                issue.addToAssignees(User.get(it))
            }
        }

        Repository repository = Repository.get(issueCO.repositoryId)
        issue.project = repository
        if (AppUtil.save(issue)) {
            IssueOpenedMessage message = new IssueOpenedMessage(issue, User.getTeamMembersByRepository(issue?.project?.id as Long))
            rabbitSend "email", "email.issue", message
            return true
        } else {
            return false
        }
    }
}
