package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> userFriendList = findFriendListByUser(user, friends);
        Map<String, Integer> recommendedFriends = createRecommendedFriends(userFriendList, friends);
        recommendedFriends = visitorScore(recommendedFriends, visitors);

        return answer;
    }

    private static List<String> findFriendListByUser(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (isFriend(user, friend)) {
                String friendName = findFriendByName(user, friend);
                friendList.add(friendName);
            }
        }
        return friendList;
    }

    private static Map<String, Integer> createRecommendedFriends(List<String> userFriends, List<List<String>> friends) {
        Map<String, Integer> result = new HashMap<>();
        for (String userFriend : userFriends) {
            for (List<String> friend : friends) {
                if (isFriend(userFriend, friend)) {
                    String name = findFriendByName(userFriend, friend);
                    Integer score = result.getOrDefault(name, 0);
                    result.put(name, score + 10);
                }
            }
        }
        return result;
    }

    private static Map<String, Integer> visitorScore(Map<String, Integer> recommendedFriendMap, List<String> visitors) {
        for (String visitor : visitors) {
            if (recommendedFriendMap.containsKey(visitor)) {
                Integer score = recommendedFriendMap.get(visitor);
                recommendedFriendMap.put(visitor, score + 1);
            }
        }
        return recommendedFriendMap;
    }

    private static boolean isFriend(String target, List<String> friend) {
        return nameEq(target, friend.get(0)) || nameEq(target, friend.get(1));
    }

    private static String findFriendByName(String target, List<String> friend) {
        if (nameEq(target, friend.get(0))) {
            return friend.get(1);
        } else {
            return friend.get(0);
        }
    }

    private static boolean nameEq(String user, String target) {
        return user.equals(target);
    }
}
