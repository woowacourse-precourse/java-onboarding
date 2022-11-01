package onboarding.problem7;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> database;

    public UserRepository() {
        this.database = new HashMap<>();
    }

    public void save(String username, User user) {
        database.put(username, user);
    }

    public Map<String, User> findAll() {
        return database;
    }

    public User findByUsername(String username) {
        return database.get(username);
    }
}
