package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserStore {
    private static Map<String, User> userStore = new HashMap<>();

    public static void add(User user) {
        if (!userStore.containsKey(user.getName())) {
            userStore.put(user.getName(), user);
        }
    }

    public static List<String> findAll() {
        return userStore.keySet().stream().collect(Collectors.toList());
    }

    public static void clear() {
        userStore.clear();
    }
}
