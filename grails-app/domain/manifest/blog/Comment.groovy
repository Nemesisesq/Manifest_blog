package manifest.blog

import grails.rest.Resource
import org.joda.time.LocalDate


@Resource
class Comment {
    String author
    String body
    LocalDate dateCreated

    static belongsTo = [post: Post]

    static constraints = {
        body size: 0..5000
    }
}
