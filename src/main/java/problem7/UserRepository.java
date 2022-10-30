package problem7;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<String, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public void save(String userId, User user) {
        if (!users.containsKey(userId)) {
            users.put(userId, user);
        }
    }

    public User findByUserid(String userId) {
        return users.get(userId);
    }
}
