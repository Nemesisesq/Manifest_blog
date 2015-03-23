import manifest.blog.Post
import manifest.blog.Comment

class BootStrap {

    def init = { servletContext ->
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
                dateCreated: new Date(),
                author: "mike",
                draft: false,
        ).addToComments(author: 'Dan', body:"High Life mixtape skateboard, four loko chillwave church-key Austin " +
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
                dateCreated: new Date(),
                author: "mike",
                draft: false,
        ).addToComments(author: 'Dan dN THE DON', body:"High Life mixtape skateboard, four loko chillwave church-key Austin " +
                "hashtag Etsy. Sriracha before they sold out gastropub cliche swag, post-ironic shabby chic 3 wolf moon " +
                "DIY polaroid direct trade viral sartorial Pitchfork selfies. Bicycle rights cronut Shoreditch, " +
                "gentrify pug fingerstache Pinterest hoodie 90's biodiesel aesthetic lumbersexual heirloom Tumblr " +
                "YOLO.").save()

        /*new Comment( author: "Jared", body: """
                        Organic mlkshk Wes Anderson XOXO hashtag. Blue Bottle shabby chic
                        synth, leggings authentic pop-up selvage. Semiotics small batch PBR&B, disrupt hella lo-fi
                        Pitchfork keffiyeh XOX Williamsburg slow-carb irony.""").save()*/


        //new Test( name: "test name").save()
    }
    def destroy = {
    }
}
