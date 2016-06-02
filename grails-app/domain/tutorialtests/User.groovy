package tutorialtests

class User {
	String username
	String password
    static constraints = {
    	username blank: false, nullable: false
    	password blank: false, nullable: false , password:true
    }
}
