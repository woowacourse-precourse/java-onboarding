package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> friendship = getFriendshipByFriends(friends);
        Map<String, Integer> scores = calculateScores(user, visitors, friendship);
        return answer;
    }

    private static List<Map.Entry<String, Integer>> sortRecommendations(Map<String, Integer> scores) {
        return scores.entrySet().stream()
                .sorted((o1, o2) -> o1.getValue() == o2.getValue()
                        ? o1.getKey().compareTo(o2.getKey())
                        : o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());
    }

    private static Map<String, List<String>> getFriendshipByFriends(List<List<String>> friends) {
        Map<String, List<String>> friendship = new HashMap<>();
        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);
            friendship.putIfAbsent(idA, new ArrayList<>());
            friendship.putIfAbsent(idB, new ArrayList<>());
            friendship.get(idA).add(idB);
            friendship.get(idB).add(idA);
        }
        return friendship;
    }

    private static Map<String, Integer> calculateScores(String user, List<String> visitors, Map<String, List<String>> friendship) {
        Map<String, Integer> scores = new HashMap<>();
        addScoresByFriendship(user, friendship, scores);
        addScoresByVisitors(user, visitors, friendship, scores);
        return scores;
    }

    private static Map<String, Integer> addScoresByFriendship(String user, Map<String, List<String>> friendship, Map<String, Integer> scores) {
        for (String id : friendship.keySet()) {
            if (user.equals(id) || isFriend(user, id, friendship)) {
                continue;
            }
            scores.put(id, 10 * countSameFriend(user, id, friendship));
        }
        return scores;
    }

    private static int countSameFriend(String user, String otherUser, Map<String, List<String>> friendship) {
        int sameFriendCnt = 0;
        for (String friend : friendship.get(otherUser)) {
            if (isFriend(user, friend, friendship)) {
                sameFriendCnt++;
            }
        }
        return sameFriendCnt;
    }

    private static void addScoresByVisitors(String user, List<String> visitors, Map<String, List<String>> friendship, Map<String, Integer> scores) {
        for (String visitor : visitors) {
            if (isFriend(user, visitor, friendship)) {
                continue;
            }
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }

    private static boolean isFriend(String user, String otherUser, Map<String, List<String>> friendship) {
        return friendship.get(user).contains(otherUser);
    }
}
