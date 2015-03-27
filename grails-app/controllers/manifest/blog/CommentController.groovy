package manifest.blog

import grails.rest.RestfulController


class CommentController extends RestfulController {
    static responseFormats = ['json', 'xml']

    CommentController() {
        super(Comment)
    }

    @Override
    def index() {

        def postId = params.postId
        def r = request.JSON

        def offset = r.offset ?: 0
        def maxPosts = r.maxPosts ?: 10

        respond Comment.where {
            post.id == postId
        }.list(offset: offset,
                max: maxPosts,
                sort: "dateCreated",
                order: "desc")
    }

    @Override
    def save() {

        def r = request.JSON
        def c = new Comment(author: r.author, body: r.body, post: params.postId).save()
        respond c
    }
}
