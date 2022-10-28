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

    public void addFriend(String userName1, String userName2){
        if(!users.containsKey(userName1)){
            addUser(userName1);
        }
        if(!users.containsKey(userName2)){
            addUser(userName2);
        }

        addFriend(users.get(userName1), userName2);
        addFriend(users.get(userName2), userName1);
    }

    private void addFriend(User user, String friendName){
        user.addFriend(friendName);
        users.put(user.getName(), user);
    }
}
