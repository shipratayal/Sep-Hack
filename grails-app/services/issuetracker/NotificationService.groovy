package issuetracker

import com.User
import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.enums.NotificationType
import com.nexthoughts.notification.Notification
import grails.transaction.Transactional

@Transactional
class NotificationService {

    Notification createNotifiction(Repository repository, User createdBy, NotificationType notificationType) {
        Notification notification = new Notification(createdBy: createdBy, type: notificationType)
        notification.notifyTo = []
        notification.save(flush: true)
        return notification
    }
}
