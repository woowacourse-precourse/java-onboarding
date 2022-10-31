package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Integer ANSWER_LIMIT_SIZE = 5;
    private static final Integer VISITOR_SCORE = 1;
    private static final Integer MUTUAL_FRIEND_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return new User(user, getFriendsByUser(user, friends), visitors).getRecommendFriendNames(friends);
    }

    private static HashSet<String> getFriendsByUser(String userName, List<List<String>> friendRelations) {
        List<String> result = new ArrayList<>();

        for (List<String> users: friendRelations) {
            String userA = users.get(0);
            String userB = users.get(1);

            if (userA.equals(userName)) {
                result.add(userB);
            } else if (userB.equals(userName)) {
                result.add(userA);
            }
        }

        return new HashSet<>(result);
    }


    private static class User {
        String userName;
        HashSet<String> friends;
        List<String> visitors;

        public User(String userName, HashSet<String> friends, List<String> visitors) {
            this.userName = userName;
            this.friends = friends;
            this.visitors = visitors;
        }


        public List<String> getRecommendFriendNames(List<List<String>> friendRelations) {
            Map<String, Integer> scoreMap = getScoreMap(this.friends, this.withoutUserFriendRelations(friendRelations), visitors);
            List<Map.Entry<String, Integer>> list = new ArrayList<>(scoreMap.entrySet());

            list.sort((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            });


            return list.stream().map(Map.Entry::getKey).limit(ANSWER_LIMIT_SIZE).collect(Collectors.toList());
        }

        private List<List<String>> withoutUserFriendRelations(List<List<String>> friendRelations) {
           return friendRelations.stream()
                    .filter((users) -> !users.contains(this.userName))
                    .collect(Collectors.toList());
        }
    }

    private static Map<String, Integer> getScoreMap(HashSet<String> userFriendSet, List<List<String>> friends,
                                                  List<String> visitors) {
        Map<String, Integer> result = new HashMap<>();

        mutualFriendScore(result, userFriendSet, friends);
        visitorScore(result, userFriendSet, visitors);

        return result;
    }

    private static void visitorScore(Map<String, Integer> scoreMap, HashSet<String> userFriendSet,
                                      List<String> visitors) {
        for (String visitor: visitors) {
            if (userFriendSet.contains(visitor)) {
                continue;
            }

            updateScore(scoreMap, visitor, VISITOR_SCORE);
        }
    }

    private static void mutualFriendScore(Map<String, Integer> scoreMap, HashSet<String> userFriendSet,
                                          List<List<String>> friends) {
        for (List<String> list: friends) {
            String friendA = list.get(0);
            String friendB = list.get(1);

            updateMutualFriendScore(scoreMap, userFriendSet, friendA, friendB);
            updateMutualFriendScore(scoreMap, userFriendSet, friendB, friendA);
        }
    }

    private static void updateMutualFriendScore(Map<String, Integer> scoreMap, HashSet<String> userFriendSet,
                                          String scoreReceiver, String friend) {
        if (userFriendSet.contains(scoreReceiver) || !userFriendSet.contains(friend)) {
            return;
        }

        updateScore(scoreMap, scoreReceiver, MUTUAL_FRIEND_SCORE);
    }

    private static void updateScore(Map<String, Integer> scoreMap, String receiver, Integer score) {
        if (!scoreMap.containsKey(receiver)) {
            scoreMap.put(receiver, score);
        } else {
            scoreMap.put(receiver, scoreMap.get(receiver) + score);
        }
    }
}
