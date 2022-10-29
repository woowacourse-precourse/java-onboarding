package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserScore {
    private Map<String, Integer> userScores = new HashMap<>();

    public void addFriendsScore(String user, Map<String, Set<String>> friendRelations) {
        for (String userFriend : friendRelations.get(user)) {
            friendRelations.get(userFriend)
                    .stream()
                    .filter(userId -> !user.equals(userId))
                    .forEach(userId -> {
                        if (userScores.containsKey(userId))
                            increase10Score(userId);
                        else
                            userScores.put(userId, 10);
                    });
        }
    }

    public void increase10Score(String user) {
        userScores.put(user, userScores.get(user) + 10);
    }

    public void addVisitorsScore(List<String> visitors, Set<String> userFriends) {
        visitors.forEach(visitor -> {
            if (!userFriends.contains(visitor)) {
                if (userScores.containsKey(visitor))
                    increase1Score(visitor);
                else
                    userScores.put(visitor, 1);
            }
        });
    }

    public void increase1Score(String user) {
        userScores.put(user, userScores.get(user) + 1);
    }

    public List<String> getUserScoreTop5() {
        return userScores.keySet()
                .stream()
                .sorted((this::valueDescIfEqualsNameAsc))
                .limit(5)
                .collect(Collectors.toList());
    }

    private int valueDescIfEqualsNameAsc(String o1, String o2) {
        if (userScores.get(o2).equals(userScores.get(o1)))
            return o1.compareTo(o2);
        return userScores.get(o2).compareTo(userScores.get(o1));
    }
}
