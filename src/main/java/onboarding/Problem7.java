package onboarding;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {

    public static List<String> solution(
        String user,
        List<List<String>> friends,
        List<String> visitors
    ) {
        HashMap<String, Integer> recommendScores = getRecommendScores(user, friends, visitors);
        return answer;
    }

    private static HashMap<String, Integer> getRecommendScores(
        String user,
        List<List<String>> friends,
        List<String> visitors
    ) {
        List<String> userFriends = getUserFriends(user, friends);

        HashMap<String, Integer> recommendScores = new HashMap<>();

        friends.forEach(friendPair -> {
                String friendA = friendPair.get(0);
                String friendB = friendPair.get(1);

                if (friendA.equals(user) || friendB.equals(user)) {
                    return;
                }

                if (userFriends.contains(friendA) && !userFriends.contains(friendB)) {
                    Integer recommendScore = recommendScores.getOrDefault(friendB, 0);
                    recommendScores.put(
                        friendB,
                        recommendScore + Score.ACQUAINTANCE_WITH_USER.value
                    );
                } else if (!userFriends.contains(friendA) && userFriends.contains(friendB)) {
                    Integer recommendScore = recommendScores.getOrDefault(friendA, 0);
                    recommendScores.put(
                        friendA,
                        recommendScore + Score.ACQUAINTANCE_WITH_USER.value
                    );
                }
            }
        );

        visitors.forEach(visitor -> {
            if (!userFriends.contains(visitor)) {
                Integer recommendScore = recommendScores.getOrDefault(visitor, 0);
                recommendScores.put(visitor, recommendScore + Score.VISIT_TIMELINE.value);
            }
        });

        return recommendScores;
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        Stream<List<String>> userFriendPairs = friends.stream()
            .filter(friendPair -> friendPair.contains(user));

        Stream<String> userFriends = userFriendPairs
            .flatMap(Collection::stream)
            .filter(userFriend -> !userFriend.equals(user));

        return userFriends
            .collect(Collectors.toList());
    }

    private enum Score {
        ACQUAINTANCE_WITH_USER(10),
        VISIT_TIMELINE(1);

        private final int value;

        Score(int value) {
            this.value = value;
        }
    }
}
