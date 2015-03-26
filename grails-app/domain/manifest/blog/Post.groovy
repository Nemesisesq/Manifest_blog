package manifest.blog

import org.joda.time.*

import grails.rest.Resource

@Resource
class Post {
    String title
    String subtitle
    String body
    String author
    LocalDate dateCreated
    Boolean draft
    String slug

    static hasMany = [comments: Comment]

    static constraints = {
        body size: 0..5000
    }

    def beforeValidate(){
        def title = this.title.replaceAll(" ", "-" ).replaceAll("[^a-z/A-Z | ^-]", "")
        def subtitle = this.subtitle.replaceAll(" ", "-" ).replaceAll("[^a-z/A-Z | ^-]", "")
        this.slug = new StringBuilder()
                .append(this.dateCreated)
                .append("-")
                .append(title)
                .append("-")
                .append(subtitle ?: 0)
                .toString()
    }



}
