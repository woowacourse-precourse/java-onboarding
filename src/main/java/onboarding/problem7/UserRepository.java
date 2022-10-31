package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepository {
    private HashMap<String, User> users = new HashMap<>();

    public User findByName(String name){
        User user = users.get(name);
        return user;
    }

    public void save(User user){
        users.put(user.getName(), user);
    }

    public void save(String s) {
        User user = new User(s);
        users.put(s, user);
    }
}
