package manifest.blog

import grails.rest.Resource


@Resource
class Comment {
    String author
    String body
    Date dateCreated

    static belongsTo = [post: Post]

    static constraints = {
        body size: 0..5000
    }
}
