package issuetracker

import com.User
import com.nexthoughts.issuetracker.issuetracker.IssueCO
import com.nexthoughts.stuff.Issue
import com.nexthoughts.stuff.Label
import com.nexthoughts.stuff.MileStone
import grails.transaction.Transactional

class IssueService {

    def springSecurityService

    Issue saveIssue(IssueCO issueCO){
        Issue issue = new Issue()
        issue.title = issueCO.title
        issue.description = issueCO.editor1
        issue.createdBy = springSecurityService.currentUser
        issue.mileStone = MileStone.get(issueCO?.milestone)
        if (issueCO.labels){
            issueCO.labels.each {
                issue.addToLabels(Label.get(it))
            }
        }
        if (issueCO.authors){
            issueCO.authors.each {
                issue.addToAssignees(User.get(it))
            }
        }
        issue.save(flush: true)
    }
}
