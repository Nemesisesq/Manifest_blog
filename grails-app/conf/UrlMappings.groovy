

class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/post"(resources: "post"){
            "/comments"(resources: "comment")
        }

        "/comments"(resources: "/comment")


        "/"(view:"/app/index")
        "/admin"(view:"/index")
        "500"(view:'/error')
	}
}
