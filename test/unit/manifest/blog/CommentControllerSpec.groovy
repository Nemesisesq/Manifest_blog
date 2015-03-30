package manifest.blog


import grails.test.mixin.*
import org.joda.time.LocalDate
import spock.lang.*

@TestFor(CommentController)
@Mock([Post, Comment])
class CommentControllerSpec extends Specification {

    def setup() {
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
        ).addToComments(author: 'Dan', body: "High Life mixtape skateboard, four loko chillwave church-key Austin " +
                "hashtag Etsy. Sriracha before they sold out gastropub cliche swag, post-ironic shabby chic 3 wolf moon " +
                "DIY polaroid direct trade viral sartorial Pitchfork selfies. Bicycle rights cronut Shoreditch, " +
                "gentrify pug fingerstache Pinterest hoodie 90's biodiesel aesthetic lumbersexual heirloom Tumblr " +
                "YOLO.")
                .addToComments(author: 'Mike', body: "Bacon ipsum dolor amet meatball jerky brisket boudin, frankfurter " +
                "alcatra pork loin ham hock. Biltong pork loin short loin shankle, ground round meatloaf picanha beef " +
                "ribs bacon salami kielbasa. Cow kielbasa porchetta beef tongue, kevin bacon brisket cupim pork flank" +
                " strip steak chuck capicola. Beef ribs ham hock kielbasa doner, hamburger shankle tail. Ball tip " +
                "salami prosciutto picanha flank. Pancetta landjaeger capicola t-bone short loin spare ribs hamburger " +
                "swine ribeye jerky pastrami tenderloin picanha brisket leberkas. Biltong jowl kevin, ground round " +
                "meatball filet mignon pig bresaola turkey strip steak meatloaf frankfurter.").save()

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
        ).addToComments(author: 'Dan', body: "High Life mixtape skateboard, four loko chillwave church-key Austin " +
                "hashtag Etsy. Sriracha before they sold out gastropub cliche swag, post-ironic shabby chic 3 wolf moon " +
                "DIY polaroid direct trade viral sartorial Pitchfork selfies. Bicycle rights cronut Shoreditch, " +
                "gentrify pug fingerstache Pinterest hoodie 90's biodiesel aesthetic lumbersexual heirloom Tumblr " +
                "YOLO.")
                .addToComments(author: 'Mike', body: "Bacon ipsum dolor amet meatball jerky brisket boudin, frankfurter " +
                "alcatra pork loin ham hock. Biltong pork loin short loin shankle, ground round meatloaf picanha beef " +
                "ribs bacon salami kielbasa. Cow kielbasa porchetta beef tongue, kevin bacon brisket cupim pork flank" +
                " strip steak chuck capicola. Beef ribs ham hock kielbasa doner, hamburger shankle tail. Ball tip " +
                "salami prosciutto picanha flank. Pancetta landjaeger capicola t-bone short loin spare ribs hamburger " +
                "swine ribeye jerky pastrami tenderloin picanha brisket leberkas. Biltong jowl kevin, ground round " +
                "meatball filet mignon pig bresaola turkey strip steak meatloaf frankfurter.").save()

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
        ).addToComments(author: 'Dan dN THE DON', body: "High Life mixtape skateboard, four loko chillwave church-key Austin " +
                "hashtag Etsy. Sriracha before they sold out gastropub cliche swag, post-ironic shabby chic 3 wolf moon " +
                "DIY polaroid direct trade viral sartorial Pitchfork selfies. Bicycle rights cronut Shoreditch, " +
                "gentrify pug fingerstache Pinterest hoodie 90's biodiesel aesthetic lumbersexual heirloom Tumblr " +
                "YOLO.").save()
    }

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns a list of posts"() {

        when: "The index action is executed and there is no post.id"
        controller.index()

        then: "The model is correct"
        response.text != ""
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.JSON = /{"author":"mike", "body":"Hello everyone I want to let you know about a special event that we are throwing in the begining of May."}/
        params.postId = 12
        controller.save()

        then: "the response is a 404"
        def r = response
        response.status == 404

        when: "The save action is executed with a valid instance"
        def c = Comment.list()
        request.JSON = /{"author":"mike", "body":"Hello everyone I want to let you know about a special event that we are throwing in the beggining of May."}/
        params.postId = 1
        controller.save()

        then: "then the instance saves to the comment"
        c.size() < Comment.list().size()
    }

}
