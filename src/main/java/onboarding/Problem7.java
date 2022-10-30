package onboarding;

import onboarding.problem7.RecommendedFriend;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int LIMIT_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendList = createFriendList(friends);
        Map<String, Integer> recommendedFriendList = createRecommendedFriendList(user, friendList);
        recommendedFriendList = visitorScore(friendList.get(user), recommendedFriendList, visitors);
        List<String> result = findNames(recommendedFriendList);
        return result;
    }

    private static Map<String, List<String>> createFriendList(List<List<String>> friends) {
        Map<String, List<String>> result = new HashMap<>();
        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            List<String> userAFriends = result.getOrDefault(userA, new ArrayList<>());
            userAFriends.add(userB);
            result.put(userA, userAFriends);

            List<String> userBFriends = result.getOrDefault(userB, new ArrayList<>());
            userBFriends.add(userA);
            result.put(userB, userBFriends);
        }
        return result;
    }

    private static Map<String, Integer> createRecommendedFriendList(String user, Map<String, List<String>> friendList) {
        Map<String, Integer> result = new HashMap<>();
        List<String> userFriends = friendList.getOrDefault(user, new ArrayList<>());
        for (String userFriend : userFriends) {
            List<String> friends = friendList.getOrDefault(userFriend, new ArrayList<>());
            for (String friend : friends) {
                if (!user.equals(friend)) {
                    Integer score = result.getOrDefault(friend, 0);
                    result.put(friend, score + 10);
                }
            }
        }
        return result;
    }

    private static Map<String, Integer> visitorScore(List<String> userFriendList, Map<String, Integer> recommendedFriendList, List<String> visitors) {
        for (String visitor : visitors) {
            if (!userFriendList.contains(visitor)) {
                Integer score = recommendedFriendList.getOrDefault(visitor, 0);
                recommendedFriendList.put(visitor, score + 1);
            }
        }
        return recommendedFriendList;
    }

    private static List<String> findNames(Map<String, Integer> recommendedFriendList) {
        List<RecommendedFriend> collect = recommendedFriendList.keySet()
                .stream()
                .map(name -> new RecommendedFriend(name, recommendedFriendList.get(name)))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        return filterByLimitSize(collect);
    }

    private static List<String> filterByLimitSize(List<RecommendedFriend> content) {
        return content.stream().map(RecommendedFriend::getName)
                .limit(LIMIT_SIZE)
                .collect(Collectors.toList());
    }
}
