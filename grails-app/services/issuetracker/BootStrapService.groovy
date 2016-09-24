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
            println " ****** Adding Admin 1 **************"
            User admin1 = new User(username: "admin1@email.com", password: 'admin123')
            admin1.save(flush: true)
            UserRole userRole = new UserRole(user: admin1, role: adminRole)
            userRole.save(flush: true)
        }
        if (!User.countByUsername("admin2@nexthoughts.com")) {
            println " ****** Adding Admin 2 **************"
            User admin2 = new User(username: "admin2@email.com", password: 'admin123')
            admin2.save(flush: true)
            UserRole userRole = new UserRole(user: admin2, role: adminRole)
            userRole.save(flush: true)
        }
        if (!User.countByUsername("admin3@nexthoughts.com")) {
            println " ****** Adding Admin 3 **************"
            User admin3 = new User(username: "admin3@email.com", password: 'admin123')
            admin3.save(flush: true)
            UserRole userRole = new UserRole(user: admin3, role: adminRole)
            userRole.save(flush: true)
        }
    }
}
