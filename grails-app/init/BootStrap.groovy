import tutorialtests.Participant
import tutorialtests.User

class BootStrap {

    def init = { servletContext ->
    	Participant p1 = new Participant(name:"Paul", adress:"15 plop Street", age:22, comment:"yeaah", special:"darkvador").save()
    	/*Participant p2 = new Participant(name:"Jacques", adress:"185 Arbre Street", age:22, special:"darksidius").save()
    	Participant p3 = new Participant(name:"Henri", adress:"78 Chat Street", age:22, comment:"yeaah", special:"darktyranitus").save()*/
        User u1 = new User(username: "admin", password: "admin").save()
    }
    def destroy = {
    }
}
