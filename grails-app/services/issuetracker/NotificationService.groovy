package issuetracker

import com.User
import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.enums.NotificationType
import com.nexthoughts.notification.Notification

class NotificationService {

    static transactional = false

    Notification createNotifiction(Repository repository, User createdBy, NotificationType notificationType) {
        Notification notification = new Notification(createdBy: createdBy, type: notificationType)
        notification.notifyTo = User.getTeamMembersByRepository(repository?.id)
        notification.save(flush: true)
        return notification
    }
}