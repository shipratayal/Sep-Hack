class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'public', action: 'index')
        "/register"(controller: "public", action: "register")
        "/signup"(controller: "public", action: "signUp")
        "/repository"(controller: 'repository', action: 'index')
        "500"(view: '/error')

        //SEO URL
        name repository: "/repository/$id?/$name?/" {
            controller = "repository"
            action = "showTickets"
        }
    }
}
