package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public void create(List<String> names) {
        for(String name : names) {
            users.add(new User(name, 0, false));
        }
    }
}
