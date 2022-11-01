package onboarding;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {

    public static List<String> solution(
        String user,
        List<List<String>> friends,
        List<String> visitors
    ) {
        HashMap<String, Integer> recommendScores = getRecommendScores(user, friends, visitors);
        return getRecommendUsers(recommendScores);
    }

    private static List<String> getRecommendUsers(HashMap<String, Integer> recommendScores) {
        List<Map.Entry<String, Integer>> recommendUsers = new LinkedList<>(
            recommendScores.entrySet());
        recommendUsers.sort(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                Integer o1Value = o1.getValue();
                Integer o2Value = o2.getValue();
                if (o1Value.equals(o2Value)) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2Value - o1Value;
            }
        });

        return recommendUsers.stream()
            .filter(recommendUser -> recommendUser.getValue() > 0)
            .map(Entry::getKey)
            .limit(5)
            .collect(Collectors.toList());
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
