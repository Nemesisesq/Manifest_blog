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

        respond Comment.where {
            post.id == postId
        }.list()
    }

    @Override
    def save() {

        def r = request.JSON
        new Comment(author: r.author, body: r.body, post: params.postId).save()
        respond r
    }
}
