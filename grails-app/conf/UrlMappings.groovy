import manifest.blog.PostController

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

        "/post/search"(controller: "post", action: 'search')


        "/comments"(resources: "/comment")


        "/"(view:"/app/index")
        "/admin"(view:"/index")
        "500"(view:'/error')
	}
}
