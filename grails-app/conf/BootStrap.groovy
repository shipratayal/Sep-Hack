import issuetracker.BootStrapService

class BootStrap {


    BootStrapService bootStrapService

    def init = { servletContext ->
        bootStrapService.createUsersAndRoles()
    }
    def destroy = {
    }
}
