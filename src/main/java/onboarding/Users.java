package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
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

    public UserMatchingList getUserMatchingList() {
        List<Users> list = new ArrayList<>();

        for (int i = 0; i < this.users.size(); i++) {
            for (int j = i + 1; j < this.users.size(); j++) {
                list.add(new Users(Arrays.asList(this.users.get(i), this.users.get(j))));
            }
        }
        return new UserMatchingList(list);
    }
}
