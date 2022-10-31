package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {

    /**
     * 기능 목록 작성
     * 1. 유저의 친구를 찾는 기능
     * 2. 유저의 친구의 친구를 찾는 기능
     * 3. 친구의 친구 점수와 방문자의 점수를 합해서 가지고있는 기능
     * 4. 점수를 비교해 상위 5명만 반환하는 기능
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = findUserFriends(user, friends);
        List<String> friendOfFriends = findFriendOfFriends(user, friends, userFriends);

        Map<String, Integer> score = getRecommendationScore(visitors, userFriends, friendOfFriends);

        return getRecommendationTopFiveFriends(score);
    }

    private static List<String> getRecommendationTopFiveFriends(Map<String, Integer> score) {
        return score.entrySet().stream()
            .sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
            .map(Entry::getKey)
            .limit(5)
            .collect(Collectors.toList());
    }

    private static Map<String, Integer> getRecommendationScore(List<String> visitors, List<String> userFriends,
        List<String> friendOfFriends) {
        Map<String, Integer> score = new HashMap<>();
        for (String friendOfFriend : friendOfFriends) {
            score.put(friendOfFriend, score.getOrDefault(friendOfFriend, 0) + 10);
        }
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) {
                continue;
            }
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }
        return score;
    }

    private static List<String> findFriendOfFriends(String user, List<List<String>> friends, List<String> userFriends) {
        List<String> friendOfFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                continue;
            }
            if (userFriends.contains(friend.get(0))) {
                friendOfFriends.add(friend.get(1));
            }
            if (userFriends.contains(friend.get(1))) {
                friendOfFriends.add(friend.get(0));
            }
        }
        return friendOfFriends;
    }

    private static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            }
            if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
        return userFriends;
    }
}
