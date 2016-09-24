package issuetracker

import com.Role
import com.User
import com.UserRole
import grails.transaction.Transactional

@Transactional
class BootStrapService {


    public void createUsersAndRoles(){
        createRoles()
        createAdmins()
        createUsers()
    }

    public void createRoles(){
        if (Role.count < 1){
            println("========= Adding Roles =============")
            new Role(authority : "ROLE_ADMIN").save(flush: true)
            new Role(authority: "ROLE_USER").save(flush: true)
        }
    }

    public void createAdmins(){
        Role adminRole = Role.findByAuthority("ROLE_ADMIN")
        if (!User.countByUsername("admin1@nexthoughts.com")) {
            println " ========== Adding Admin 1 ========="
            User admin1 = new User(username: "admin1@nexthoughts.com", password: 'admin123',firstName: "Neon",lastName: "Admin")
            admin1.save(flush: true)
            UserRole userRole = new UserRole(user: admin1, role: adminRole)
            userRole.save(flush: true)
        }
        if (!User.countByUsername("admin2@nexthoughts.com")) {
            println " ========= Adding Admin 2 ========="
            User admin2 = new User(username: "admin2@nexthoughts.com", password: 'admin123',firstName: "Frodo",lastName: "Admin")
            admin2.save(flush: true)
            UserRole userRole = new UserRole(user: admin2, role: adminRole)
            userRole.save(flush: true)
        }
        if (!User.countByUsername("admin3@nexthoughts.com")) {
            println " ========= Adding Admin 3 ========="
            User admin3 = new User(username: "admin3@nexthoughts.com", password: 'admin123',firstName: "Logan",lastName: "Admin")
            admin3.save(flush: true)
            UserRole userRole = new UserRole(user: admin3, role: adminRole)
            userRole.save(flush: true)
        }
    }

    public void createUsers(){
        Role adminRole = Role.findByAuthority("ROLE_USER")
        if (!User.countByUsername("user1@nexthoughts.com")) {
            println " ========= Adding User 1 ==========="
            User user1 = new User(username: "user1@nexthoughts.com", password: 'user123',firstName: "Kevin",lastName: "Leon")
            user1.save(flush: true)
            UserRole userRole = new UserRole(user: user1, role: adminRole)
            userRole.save(flush: true)
        }
        if (!User.countByUsername("user2@nexthoughts.com")) {
            println " ========= Adding User 2 ==========="
            User user2 = new User(username: "user2@nexthoughts.com", password: 'user123',firstName: "Dwayne",lastName: "Johnson")
            user2.save(flush: true)
            UserRole userRole = new UserRole(user: user2, role: adminRole)
            userRole.save(flush: true)
        }
        if (!User.countByUsername("user3@nexthoughts.com")) {
            println " =========== Adding User 3 ==========="
            User user3 = new User(username: "user3@nexthoughts.com", password: 'user123',firstName: "Matt",lastName: "Morgan")
            user3.save(flush: true)
            UserRole userRole = new UserRole(user: user3, role: adminRole)
            userRole.save(flush: true)
        }
    }
}
