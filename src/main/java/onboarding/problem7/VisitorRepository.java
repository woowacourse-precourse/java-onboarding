package onboarding.problem7;

import java.util.HashMap;
import java.util.Map;

public class VisitorRepository {
    private final Map<User, Visitor> database;

    public VisitorRepository() {
        this.database = new HashMap<>();
    }

    public void save(User user, Visitor visitor) {
        database.put(user, visitor);
    }

    public Visitor findByUser(User user) {
        return database.get(user);
    }
}
