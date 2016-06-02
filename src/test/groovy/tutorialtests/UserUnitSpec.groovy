package tutorialtests

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserUnitSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Form is not working if username or password are null"() {
        given:
            def u1 = new User(name: null, adress: null)
        when:
            def v = u1.validate()
        then:
            v == false
            u1.errors.errorCount == 2
            //assertEquals
            u1.errors.getFieldError("username").getCode() ==  "nullable"
            u1.errors.getFieldError("password").getCode() ==  "nullable"
    }

    void "Form is not working if name, age or adress are blank"() {
        given:
            def u1 = new User(name: "", adress: "")
        when:
            def v = u1.validate()
        then:
            v == false
            u1.errors.errorCount == 2
            u1.errors.getFieldError("username").getCode() ==  "nullable"
            u1.errors.getFieldError("password").getCode() ==  "nullable"
    }

    void "If both are filled up, it works"() {
        given:
            def u1 = new User(name: "", adress: "")
        when:
            def v = u1.validate()
        then:
            v == false
            u1.errors.errorCount == 2
            //assertEquals
            u1.errors.getFieldError("username").getCode() ==  "nullable"
            u1.errors.getFieldError("password").getCode() ==  "nullable"
    }


}
