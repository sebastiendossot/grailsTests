package tutorialtests

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
@Stepwise
class UserSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Connection failed, wrong user"() {
        when:"The connection page is visited"
            go '/user/connection'
            $('input', id:'username') << "wrong"
            $('input', id:'password') << "wrong"
            $('input#authentification').click()
        then:"wrong user"
            driver.currentUrl == "http://localhost:8080/user/connection"
            $('div', class:"alert alert-danger").text() == 'Not the good username or password'
    }

    void "Connection succeed"() {
        when:"The connection page is visited"
        go '/user/connection'
        $('input', id:'username') << "admin"
        $('input', id:'password') << "admin"
        $('input#authentification').click()
        then:"The password is correct"
        driver.currentUrl == "http://localhost:8080/"
        $('a', class:"create").text() == "New Participant"
    }

    void "Add new participant"() {
        when:"The admin is connected and the create participant page is visited"
        go '/participant/create'
        $('input', id:'name') << "admin"
        $('input', id:'adress') << "admin street"
        $('input', id:'age') << "25"
        $('input', id:'comment') << "it' an admin"
        $('input', id:'special') << "dark admin"
        $('input#save').click()
        then:"The inputs are correct"
        driver.currentUrl == "http://localhost:8080/"
        $('a', href:"/participant/show/2").text() == "admin"

    }
}

