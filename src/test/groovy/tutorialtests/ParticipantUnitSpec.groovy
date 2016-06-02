package tutorialtests

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Participant)
class ParticipantUnitSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


	void "Form is not working if name, age or adress are null"() {
		given:
		def p1 = new Participant(name: null, adress: null, age: null, comment:null, special:null)
		when:
		def v = p1.validate()
		then:
		v == false
		p1.errors.errorCount == 4

		p1.errors.getFieldError("name").getCode() ==  "nullable"
		p1.errors.getFieldError("adress").getCode() ==  "nullable"
		p1.errors.getFieldError("age").getCode() ==  "nullable"
		p1.errors.getFieldError("special").getCode() ==  "nullable"
	}

	void "Form is not working if name, age or adress are blank"() {
		given:
		def p1= new Participant(name: "", adress: "", age: "", comment:"", special:"")
		when:
		def v = p1.validate()
		then:
		v == false
		p1.errors.errorCount == 4
		//log.error(p1.errors.getFieldError('name'))
		/*p1.errors.allErrors.each{
			log.error it
		}*/
		p1.errors.getFieldError("name").getCode() ==  "nullable"
		p1.errors.getFieldError("adress").getCode() ==  "nullable"
		p1.errors.getFieldError("age").getCode() ==  "nullable"
		p1.errors.getFieldError("special").getCode() ==  "nullable"
	}

	void "All the fields are filled up it works"() {
		given:
		def p1= new Participant(name: "a", adress:"4 hey road", age:25, comment:"hello", special:"darkvador")
		when:
		def v = p1.validate()
		then:
		v == true
		p1.errors.errorCount == 0
	}

	void "All the fields are filled up except the comment and it still works"() {
		given:
		def p1= new Participant(name: "a", adress:"4 hey road", age:25, comment:"hello", special:"darkchaussette")
		when:
		def v = p1.validate()
		then:
		v == true
		p1.errors.errorCount == 0
	}

	void "age under 20 doesn't work"() {
		given:
		def p1= new Participant(name: "a", adress:"4 hey road", age:15, comment:"hello", special:"darkchaussette")
		when:
		def v = p1.validate()
		then:
		v == false
		p1.errors.errorCount == 1
		p1.errors.getFieldError("age").getCode() ==  "min.notmet"

	}

	void "The special validator is not respected"() {
		given:
		def p1= new Participant(name: "a", adress:"4 hey road", age:25, comment:"hello", special:"dartpator")
		when:
		def v = p1.validate()
		then:
		v == false
		p1.errors.errorCount == 1
		p1.errors.getFieldError("special").getCode() ==  "invalid.vador"

	}

	void "A participant already exists"() {
		given:
		new Participant(name: "a", adress:"4 hey road", age:25, comment:"hello", special:"darkcitrus").save(flush:true)
		def p2= new Participant(name: "a", adress:"4 hey road", age:25, comment:"hello", special:"darkcitrus")
		when:
		def v = p2.validate()
		then:
		v == false
		p2.errors.errorCount == 1
		p2.errors.getFieldError("name").getCode() ==  "unique"
	}

}
