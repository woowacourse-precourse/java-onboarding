package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Integer ANSWER_LIMIT_SIZE = 5;
    private static final Integer VISITOR_SCORE = 1;
    private static final Integer MUTUAL_FRIEND_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> userFriendMap = new HashSet<>(getFriendListOfUser(user, friends));

        List<List<String>> withoutUserFriends = friends.stream()
                .filter((users) -> !users.contains(user))
                .collect(Collectors.toList());

        Map<String, Integer> scoreMap = getScoreMap(userFriendMap, withoutUserFriends, visitors);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(scoreMap.entrySet());

        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });


        return list.stream().map(Map.Entry::getKey).limit(ANSWER_LIMIT_SIZE).collect(Collectors.toList());
    }

    private static Map<String, Integer> getScoreMap(HashSet<String> userFriendMap, List<List<String>> friends,
                                                  List<String> visitors) {
        Map<String, Integer> result = new HashMap<>();

        mutualFriendScore(result, userFriendMap, friends);
        visitorScore(result, userFriendMap, visitors);

        return result;
    }

    private static void visitorScore(Map<String, Integer> scoreMap, HashSet<String> userFriendMap,
                                      List<String> visitors) {
        for (String visitor: visitors) {
            if (userFriendMap.contains(visitor)) {
                continue;
            }

            updateScore(scoreMap, visitor, VISITOR_SCORE);
        }
    }

    private static void mutualFriendScore(Map<String, Integer> scoreMap, HashSet<String> userFriendMap,
                                          List<List<String>> friends) {
        for (List<String> list: friends) {
            String friendA = list.get(0);
            String friendB = list.get(1);

            updateMutualFriendScore(userFriendMap, scoreMap, friendA, friendB);
            updateMutualFriendScore(userFriendMap, scoreMap, friendB, friendA);
        }
    }

    private static void updateMutualFriendScore(HashSet<String> userFriendMap, Map<String, Integer> result,
                                          String scoreReceiver, String friend) {
        if (userFriendMap.contains(scoreReceiver)) {
            return;
        }

        Integer withFriendScore = getMutualFriendScore(userFriendMap, scoreReceiver, friend);
        updateScore(result, scoreReceiver, withFriendScore);
    }

    private static Integer getMutualFriendScore(HashSet<String> userFriendMap, String scoreReceiver, String friend) {
        if (userFriendMap.contains(friend) && !userFriendMap.contains(scoreReceiver)) {
            return MUTUAL_FRIEND_SCORE;
        }
        return 0;
    }

    private static void updateScore(Map<String, Integer> scoreMap, String receiver, Integer score) {
        if (!scoreMap.containsKey(receiver)) {
            scoreMap.put(receiver, score);
        } else {
            scoreMap.put(receiver, scoreMap.get(receiver) + score);
        }
    }

    private static List<String> getFriendListOfUser(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> list: friends) {
            if (list.get(0).equals(user)) {
                result.add(list.get(1));
            } else if (list.get(1).equals(user)) {
                result.add(list.get(0));
            }
        }

        return result;
    }
}
