package onboarding.problem7;

import java.util.*;

public class FriendRepository {
    private final Map<User, Friends> database;

    public FriendRepository() {
        this.database = new HashMap<>();
    }


    public boolean isNotSavedUser(User user) {
        return !database.containsKey(user);
    }

    public void save(User user, Friends friends) {
        database.put(user, friends);
    }

    public Friends findByUser(User user) {
        return database.get(user);
    }

}
