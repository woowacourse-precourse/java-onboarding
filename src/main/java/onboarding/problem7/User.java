package onboarding.problem7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {

    private final String name;
    private final List<List<String>> friends;
    private final List<String> visitors;

    private final List<String> relationships = new ArrayList<String>();

    private final Map<String, Integer> SCORES_FOR_USERS = new HashMap<String, Integer>();

    public User(String name, List<List<String>> friends, List<String> visitors) {
        this.name = name;
        this.friends = friends;
        this.visitors = visitors;
    }

    public List<String> getRecommendedUsers() {
        getScoresForUsers();
        final Comparator<String> comp = Comparator.comparingInt(SCORES_FOR_USERS::get);
        return SCORES_FOR_USERS.keySet().stream().sorted(comp.reversed()).limit(5).collect(Collectors.toList());
    }

    public void getScoresForUsers() {
        getRelationshipsForUser();
        getScoresByOverlappedUsers();
        getScoresByVisitedUsers();
    }

    private void getRelationshipsForUser() {
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
                SCORES_FOR_USERS.put(user2,
                        SCORES_FOR_USERS.containsKey(user2) ? SCORES_FOR_USERS.get(user2) + 10 : 10);
            }

            if (relationships.contains(user2) && !user1.equals(this.name)) {
                SCORES_FOR_USERS.put(user1,
                        SCORES_FOR_USERS.containsKey(user1) ? SCORES_FOR_USERS.get(user1) + 10 : 10);
            }
        }
    }

    private void getScoresByVisitedUsers() {
        for (String visitor : visitors) {
            if (!relationships.contains(visitor)) {
                SCORES_FOR_USERS.put(visitor,
                        SCORES_FOR_USERS.containsKey(visitor) ? SCORES_FOR_USERS.get(visitor) + 1 : 1);
            }
        }
    }
}
