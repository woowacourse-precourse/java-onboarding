package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = recommendList(user, friends, visitors);
        return answer;
    }

    private static List<String> recommendList(String user,List<List<String>> friends ,List<String> visitors) {

        Map<String , Set<String>> friendMap = getFriendsMap(friends);
        Map<String , Integer> recommendScoreMap = new HashMap<>();

        setFriendsScore(user, friendMap, recommendScoreMap);
        setVisitorScore(visitors, recommendScoreMap);
        deleteUserFriends(user ,friendMap, recommendScoreMap);

        List<String> result = recommendListByScoreMap(recommendScoreMap);

        return result;
    }

    private static Map<String , Set<String>> getFriendsMap(List<List<String>> friends) {
        Map<String, Set<String>> result = new HashMap<>();
        for(List<String> friend : friends) {

            if (result.containsKey(friend.get(0))) {
                result.get(friend.get(0)).add(friend.get(1));
            } else {
                result.put(friend.get(0), new HashSet<>(List.of(friend.get(1))));
            }

            if (result.containsKey(friend.get(1))) {
                result.get(friend.get(1)).add(friend.get(0));
            } else {
                result.put(friend.get(1), new HashSet<>(List.of(friend.get(0))));
            }
        }
        return result;
    }

    private static void setFriendsScore(String user, Map<String, Set<String>> friendsMap , Map<String , Integer> recommendScoreMap) {
        friendsMap.get(user).forEach(friend -> {
            friendsMap.get(friend).forEach(friendsFriend -> {
                addScore(friendsFriend, 10, recommendScoreMap);
            });
        });
    }

    private static void setVisitorScore(List<String > visitors, Map<String, Integer> recommendScoreMap) {
        visitors.forEach(visitor -> {
            addScore(visitor, 1, recommendScoreMap);
        });
    }

    private static void addScore(String recommendUser, int score, Map<String , Integer> recommendScoreMap) {
        recommendScoreMap.put(
                recommendUser,
                recommendScoreMap.get(recommendUser) != null ? recommendScoreMap.get(recommendUser) + score : score
        );
    }

    private static void deleteUserFriends(String user, Map<String, Set<String>> friendsMap, Map<String, Integer> recommendScoreMap) {
        recommendScoreMap.remove(user);
        // 이미 등록된 친구는 추천 대상에서 제외
        friendsMap.get(user).forEach(friend -> {
            recommendScoreMap.remove(friend);
        });
    }
}
