package onboarding;

import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean compareUsers() {
        return users.get(0).compareSplitList(users.get(1));
    }
}
