package problem7;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public Optional<User> findByUserid(String userId) {
        return Optional.ofNullable(users.get(userId));
    }
}
