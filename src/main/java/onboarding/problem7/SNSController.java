package onboarding.problem7;


import java.util.HashMap;

public class SNSController {

    private HashMap<String, User> users;

    public SNSController(){
        users = new HashMap<>();
    }

    public void addUser(String userName){
        users.put(userName, new User(userName));
    }
}
