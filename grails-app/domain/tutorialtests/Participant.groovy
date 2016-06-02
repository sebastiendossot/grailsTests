package tutorialtests

class Participant {
	String name
	String adress
	Integer age
	String comment
	String special
    static constraints = {
    	name blank: false, nullable: false, unique:true
    	adress blank: false, nullable: false
    	age min:20, blank: false, nullable: false
    	comment blank: true, nullable: true
    	special  validator: {
    		if (!it.startsWith('dark') ) return ['invalid.vador']
    	}
    }
}
