package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserScore {
    private Map<String, Integer> userScores = new HashMap<>();

    protected UserScore() {
    }

    public UserScore(List<String> notUserFriends, List<String> notUserFriendVisitors) {
        notUserFriends.forEach(user -> userScores.put(user, 0));
        notUserFriendVisitors.forEach(user -> userScores.put(user, 0));
    }

    public void increaseVisitors(List<String> visitors) {
        visitors.forEach(user -> {
            if (userScores.containsKey(user))
                userScores.put(user, userScores.get(user) + 1);
        });
    }

    public void increaseUserFriends(String user, Map<String, Set<String>> friendsRelations) {
        for (String userFriend : friendsRelations.get(user)) {
            friendsRelations.get(userFriend)
                    .forEach(this::increaseFriend);
        }
    }

    private void increaseFriend(String friend) {
        if (userScores.containsKey(friend))
            userScores.put(friend, userScores.get(friend) + 10);
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
