package manifest.blog

import grails.rest.RestfulController
import org.joda.time.LocalDate


class PostController extends RestfulController {
    static responseFormats = ['json', 'xml']

    PostController() {
        super(Post)
    }

    @Override
    def index() {

        def r = request.JSON

        def offset = r.offset ?: 0
        def maxPosts = r.maxPosts ?: 10
        respond Post.list(
                offset: offset,
                max: maxPosts,
                sort: "dateCreated",
                order: "desc")
    }

    @Override
    def save(){
        def r = request.JSON
        def p  = new Post(title: r.title,
                subtitle: r.subtitle,
                body: r.body,
                dateCreated: new LocalDate(),
                author: r.author,
                draft: r.draft).save()

        respond p
    }

    def search(){
        def r = webRequest
        def query = "%" + params.query + "%"
        def f = Post.findAllByTitleLike(query)
        respond f

    }

}
