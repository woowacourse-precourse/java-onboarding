package onboarding.problem7;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private static Map<String, User> userStore = new HashMap<>();

    public static void add(User user) {
        if (!userStore.containsKey(user.getName())) {
            userStore.put(user.getName(), user);
        }
    }
}
