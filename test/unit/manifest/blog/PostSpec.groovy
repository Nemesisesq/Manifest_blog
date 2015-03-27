package manifest.blog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Post)
class PostSpec extends Specification {

    def setup() {
        def p = new Post(title: 'UnitTest', subtitle: 'More Unit Test', body: 'Hello World', author: 'Mike', draft: true )
    }

    def cleanup() {
    }

    void "test that slug was created" () {
        def p = new Post(title: 'UnitTest', subtitle: 'More Unit Test', body: 'Hello World', author: 'Mike', draft: true )

        when:
            p.save()

        then:
            p.slug
    }


}
