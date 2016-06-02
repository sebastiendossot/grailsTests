package tutorialtests

class ParticipantController {

    def index() { 
    	respond Participant.list(params)
    }

    def create(){
        respond new Participant(params)
    }

    def save(Participant p){
        p.save flush:true

        redirect url:"/"
    }
}
