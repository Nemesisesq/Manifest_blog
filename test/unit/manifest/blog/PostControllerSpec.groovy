package manifest.blog

import grails.test.mixin.*
import groovy.json.JsonSlurper
import org.joda.time.LocalDate
import spock.lang.*

@TestFor(PostController)
@Mock(Post)
class PostControllerSpec extends Specification {

    void "Test the index action returns json"() {

        new Post(author: "mike",
                body: "Lorizzle stuff we gonna chung sit amizzle, black adipiscing dizzle. I'm in the shizzle yo mamma\n",
                dateCreated: new LocalDate(),
                draft: false,
                subtitle: "this is only a tes" +
                        "t but it's anothere one",
                title: "TestBlog2").save()

        when: "The index action is executed"
        controller.index()

        then: "the response is json"
        def r = response
        response.format == "json"
        //response.content.size() > 0
    }

    void "Test the save action"() {
        def preSize = Post.list().size()

        request.JSON = /{

                    "author":"mike",
                    "body":"Lorizzle stuff we gonna chung sit amizzle, black adipiscing dizzle. I'm in the shizzle yo mamma\n",
                    "draft":"false",
                    "subtitle":"this is only a test but it's anothere one",
                    title:"TestBlog4"}/
        when: "The save action is  executed"
        controller.save()

        then: "there should be another record in the database"
        preSize < Post.list().size()


    }

    void "Test the search action"() {
        new Post(
                title: "TestBlog",
                subtitle: "this is only a test",
                body: """
                        Lorizzle stuff we gonna chung sit amizzle, black adipiscing dizzle. I'm in the shizzle yo mamma
                        velit, pizzle volutpizzle, suscipizzle quis, gravida vel, pot. Pellentesque eget tortor.
                        We gonna chung sure. Mah nizzle izzle black boofron fizzle tempizzle pot.
                        Pizzle pellentesque nibh et turpizzle. Ghetto izzle tortizzle. Pellentesque eleifend rhoncizzle
                        ghetto. In hizzle habitasse for sure dictumst. Donec dapibizzle. Fo shizzle mah nizzle fo
                        rizzle, mah home g-dizzle tellizzle fo shizzle mah nizzle fo rizzle, mah home g-dizzle,
                        pretium eu, mattizzle ac, tellivizzle vitae, nunc. Shizzlin dizzle suscipizzle. Integer
                        sempizzle fo sed izzle.""",
                dateCreated: new LocalDate(),
                author: "mike",
                draft: false,
        ).save()

        new Post(
                title: "Dan Dan Dan Dan",
                subtitle: "this is only a test",
                body: """
                        Lorizzle stuff we gonna chung sit amizzle, black adipiscing dizzle. I'm in the shizzle yo mamma
                        velit, pizzle volutpizzle, suscipizzle quis, gravida vel, pot. Pellentesque eget tortor.
                        We gonna chung sure. Mah nizzle izzle black boofron fizzle tempizzle pot.
                        Pizzle pellentesque nibh et turpizzle. Ghetto izzle tortizzle. Pellentesque eleifend rhoncizzle
                        ghetto. In hizzle habitasse for sure dictumst. Donec dapibizzle. Fo shizzle mah nizzle fo
                        rizzle, mah home g-dizzle tellizzle fo shizzle mah nizzle fo rizzle, mah home g-dizzle,
                        pretium eu, mattizzle ac, tellivizzle vitae, nunc. Shizzlin dizzle suscipizzle. Integer
                        sempizzle fo sed izzle.""",
                dateCreated: new LocalDate(),
                author: "mike",
                draft: false,
        ).save()

        new Post(
                title: "TestBlog2",
                subtitle: "this is only a test but it's anothere one",
                body: """
                        Lorizzle stuff we gonna chung sit amizzle, black adipiscing dizzle. I'm in the shizzle yo mamma
                        velit, pizzle volutpizzle, suscipizzle quis, gravida vel, pot. Pellentesque eget tortor.
                        We gonna chung sure. Mah nizzle izzle black boofron fizzle tempizzle pot.
                        Pizzle pellentesque nibh et turpizzle. Ghetto izzle tortizzle. Pellentesque eleifend rhoncizzle
                        ghetto. In hizzle habitasse for sure dictumst. Donec dapibizzle. Fo shizzle mah nizzle fo
                        rizzle, mah home g-dizzle tellizzle fo shizzle mah nizzle fo rizzle, mah home g-dizzle,
                        pretium eu, mattizzle ac, tellivizzle vitae, nunc. Shizzlin dizzle suscipizzle. Integer
                        sempizzle fo sed izzle.""",
                dateCreated: new LocalDate(),
                author: "mike",
                draft: false,
        ).save()

        params.query = 'Tes'
        when: "The save action is called with a search term"

        controller.search()

        then: "a list of posts with matching titles is returned"
        def r = response.text
        def jsonObj = new JsonSlurper().parseText(response.text)
        Post.findAllByTitleLike("%" + params.query + "%").size() == jsonObj.size()
        response.format == "json"


    }

}
