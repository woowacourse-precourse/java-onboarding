package problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<String> createDefaultList(String userId) {
        return users.keySet().stream()
                .filter(s -> !s.equals(userId))
                .collect(Collectors.toList());
    }
}
