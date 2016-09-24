package issuetracker

import com.MailCO
import com.User
import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryAddMessage
import com.nexthoughts.issuetracker.rabbitmq.messages.RepositoryDeletedMessage
import com.nexthoughts.issuetracker.rabbitmq.messages.SignUpMailMessage
import com.nexthoughts.notification.Notification
import grails.transaction.Transactional

@Transactional
class RabbitMqEmailService {

    def mailService

    def sendSignupMail(SignUpMailMessage message) {
        User.withNewSession {
            User user = User.get(message?.userId)
            MailCO mailCO = new MailCO()
            mailCO.subject = "Signup Successful "
            mailCO.to = [user?.username]
            mailCO.modelMap = [user: user]
            mailCO.viewFileName = "/emailTemplates/signupEmail"
            mailCO.createdBy = user
            mailService.sendSimpleMailWithoutAttachment(mailCO)

            Notification notification = new Notification(mailCO)
        }
    }

    def sendRepositoryCreationMail(RepositoryAddMessage message) {
        println "Inside repository Creation Mail service"
        Repository.withNewSession {
            Repository repository = Repository.get(message?.repositoryId)
            MailCO mailCO = new MailCO()
            mailCO.subject = "Repository Creation Successful "
            mailCO.to = [repository?.owner?.username]
            mailCO.modelMap = [repository: repository]
            mailCO.viewFileName = "/emailTemplates/repositoryCreationEmail"
            mailCO.createdBy = repository?.owner
            mailService.sendSimpleMailWithoutAttachment(mailCO)
        }
    }

    def sendRepositoryDeletionMail(RepositoryDeletedMessage message, User user) {
        MailCO mailCO = new MailCO(message, user)
        mailService.sendSimpleMailWithoutAttachment(mailCO)
    }


}
