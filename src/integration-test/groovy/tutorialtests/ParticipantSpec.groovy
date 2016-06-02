package tutorialtests

import grails.test.mixin.integration.Integration
import grails.transaction.*

//import geb.Browser

import spock.lang.*
import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class ParticipantSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    /*def "test something"() {
        when:"The home page is visited"
            go '/'
        then:"The title is correct"
            driver.currentUrl == "http://localhost:8080/"
        	$("title").click().text() == "List"
    }*/
}
