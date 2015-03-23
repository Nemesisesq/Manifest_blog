package manifest.blog

import grails.rest.Resource

@Resource
class Post {
    String title
    String subtitle
    String body
    String author
    Date dateCreated
    Boolean draft

    static hasMany = [comments:Comment]

    static constraints = {
        body size: 0..5000
    }
}
