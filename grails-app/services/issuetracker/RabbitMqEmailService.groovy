package issuetracker

import com.MailCO
import com.User
import com.nexthoughts.issuetracker.rabbitmq.messages.SignUpMailMessage
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
            mailService.sendSimpleMailWithoutAttachment(mailCO)
        }
    }
}
