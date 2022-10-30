package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static HashMap<String, Integer> scoreMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        scoreMap = new HashMap<>();
        HashMap<String, List<String>> friendshipMap = makeFriendshipMap(friends);

        giveScoreBasedOnFriendship(user, friendshipMap);
        giveScoreBasedOnVisited(visitors);

        List<String> answer = Collections.emptyList();

        return answer;
    }

    private static void giveScoreBasedOnVisited(List<String> visitors) {
        visitors.forEach((visitor) -> {
            int curScore = scoreMap.getOrDefault(visitor, 0);

            scoreMap.put(visitor, curScore + 1);
        });
    }

    private static void giveScoreBasedOnFriendship(String user, HashMap<String, List<String>> friendshipMap) {
        List<String> userFriends = friendshipMap.get(user);

        userFriends.forEach((friend) -> {
            List<String> friendOfFriend = friendshipMap.get(friend);

            friendOfFriend.forEach((name) -> {
                int curScore = scoreMap.getOrDefault(name, 0);

                scoreMap.put(name, curScore + 10);
            });
        });
    }

    private static HashMap<String, List<String>> makeFriendshipMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendship = new HashMap<>();

        for (List<String> relation : friends) {
            String one = relation.get(0);
            String other = relation.get(1);

            List<String> oneFriends = friendship.getOrDefault(one, new ArrayList<>());
            List<String> otherFriends = friendship.getOrDefault(other, new ArrayList<>());

            oneFriends.add(other);
            otherFriends.add(one);

            friendship.put(one, oneFriends);
            friendship.put(other, otherFriends);
        }

        return friendship;
    }
}
