package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final String name;
    private final List<List<String>> friends;
    private final List<String> visitors;

    private final List<String> relationships = new ArrayList<String>();

    private final Map<String, Integer> SCORES_BY_USERS = new HashMap<String, Integer>();

    public User(String name, List<List<String>> friends, List<String> visitors) {
        this.name = name;
        this.friends = friends;
        this.visitors = visitors;
    }

    private void getRelationshipsByUser() {
        for (List<String> relation : friends) {
            String user1 = relation.get(0);
            String user2 = relation.get(1);

            if (user1.equals(this.name)) {
                relationships.add(user2);
            }
            if (user2.equals(this.name)) {
                relationships.add(user1);
            }
        }
    }

    private void getScoresByOverlappedUsers() {
        for (List<String> relation : friends) {
            String user1 = relation.get(0);
            String user2 = relation.get(1);

            if (relationships.contains(user1) && !user2.equals(this.name)) {
                SCORES_BY_USERS.put(user2, SCORES_BY_USERS.containsKey(user2) ? SCORES_BY_USERS.get(user2) + 10 : 10);
            }

            if (relationships.contains(user2) && !user1.equals(this.name)) {
                SCORES_BY_USERS.put(user1, SCORES_BY_USERS.containsKey(user1) ? SCORES_BY_USERS.get(user1) + 10 : 10);
            }
        }
    }

    private void getScoresByVisitedUsers() {
        for (String visitor : visitors) {
            if (!relationships.contains(visitor)) {
                SCORES_BY_USERS.put(visitor,
                        SCORES_BY_USERS.containsKey(visitor) ? SCORES_BY_USERS.get(visitor) + 1 : 1);
            }
        }
    }
}
