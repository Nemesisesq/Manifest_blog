package manifest.blog

import grails.converters.JSON
import grails.test.mixin.*
import org.joda.time.LocalDate
import spock.lang.*

@TestFor(PostController)
@Mock(Post)
class PostControllerSpec extends Specification {

    void "Test the index action returns the correct model"() {

            new Post(author:"mike",
                    body:"Lorizzle stuff we gonna chung sit amizzle, black adipiscing dizzle. I'm in the shizzle yo mamma\n",
                    dateCreated:new LocalDate(),
                    draft:false,
                    subtitle:"this is only a test but it's anothere one",
                    title:"TestBlog2").save()

        when:"The index action is executed"
            controller.index()

        then:"the response is json"
            response
    }

    void "test the save action"() {
        new Post(author:"mike",
                body:"Lorizzle stuff we gonna chung sit amizzle, black adipiscing dizzle. I'm in the shizzle yo mamma\n",
                dateCreated:new LocalDate(),
                draft:false,
                subtitle:"this is only a test but it's anothere one",
                title:"TestBlog2").save()

        when:"The save action is  executed"
            



        then: "there should be another record in the database"
    }

}
