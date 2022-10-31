package onboarding;

import onboarding.problem7.RecommendedFriend;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int LIMIT_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendList = createFriendList(friends);
        Map<String, Integer> recommendedFriendList = createRecommendedFriendList(user, friendList);
        visitorScore(friendList.get(user), recommendedFriendList, visitors);
        return findNames(recommendedFriendList);
    }

    private static Map<String, List<String>> createFriendList(List<List<String>> friends) {
        Map<String, List<String>> friendList = new HashMap<>();

        friends.forEach(friend -> {
            String userA = friend.get(0);
            String userB = friend.get(1);
            addFriendList(friendList, userA, userB);
            addFriendList(friendList, userB, userA);
        });

        return friendList;
    }

    private static void addFriendList(Map<String, List<String>> friendList, String user, String friend) {
        List<String> userFriends = friendList.getOrDefault(user, new ArrayList<>());
        userFriends.add(friend);
        friendList.put(user, userFriends);
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

    private static void visitorScore(List<String> userFriendList, Map<String, Integer> recommendedFriendList, List<String> visitors) {
        visitors.stream()
                .filter(visitor -> isNotUserFriend(userFriendList, visitor))
                .forEach(visitor -> recommendedFriendList.put(visitor, getScore(recommendedFriendList, visitor) + 1));
    }

    private static boolean isNotUserFriend(List<String> userFriendList, String name) {
        return !userFriendList.contains(name);
    }

    private static int getScore(Map<String, Integer> recommendedFriendList, String visitor) {
        return recommendedFriendList.getOrDefault(visitor, 0);
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
