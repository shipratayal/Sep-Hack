class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'public', action: 'index')
        "/"(controller: 'user', action: 'dashboard')
        "/register"(controller: "public", action: "register")
        "/signup"(controller: "public", action: "signUp")
        "/repository"(controller: 'repository', action: 'index')
        "500"(view: '/error')
    }
}
