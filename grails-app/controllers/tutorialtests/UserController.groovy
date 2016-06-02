package tutorialtests

class UserController {

    def index() {
    }

    def connection(){
        respond new User(params)
    }

    def authentification(User u){
        log.error u.password
        if(User.findAllByUsernameAndPassword(u.username, u.password)){
            session.username = u.username
            redirect url:"/"
        }else{
            flash.message = '<div class="alert alert-danger" role="alert">' + 'Not the good username or password' + '</div>'
            redirect action:"connection"
        }

    }

}

