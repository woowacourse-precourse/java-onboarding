package onboarding;

import onboarding.problem7.RecommendedFriend;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int LIMIT_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendList = createFriendList(friends);

        Map<String, Integer> recommendedFriendList = createRecommendedFriendList(user, friendList, visitors);

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
        List<String> userFriends = getFriendListByName(friendList, user);
        userFriends.add(friend);
        friendList.put(user, userFriends);
    }


    private static Map<String, Integer> createRecommendedFriendList(String user, Map<String, List<String>> friendList, List<String> visitors) {
        Map<String, Integer> result = new HashMap<>();

        List<String> userFriends = getFriendListByName(friendList, user);

        for (String userFriend : userFriends) {
            List<String> friends = getFriendListByName(friendList, userFriend);
            friends.stream()
                    .filter(friend -> isNotUser(user, friend))
                    .forEach(friend -> addScore(result, friend, 10));
        }

        visitorScore(userFriends, result, visitors);

        return result;
    }

    private static List<String> getFriendListByName(Map<String, List<String>> friendList, String name) {
        return friendList.getOrDefault(name, new ArrayList<>());
    }

    private static boolean isNotUser(String user, String target) {
        return !user.equals(target);
    }

    private static void addScore(Map<String, Integer> content, String name, int score) {
        content.put(name, content.getOrDefault(name, 0) + score);
    }

    private static void visitorScore(List<String> userFriendList, Map<String, Integer> recommendedFriendList, List<String> visitors) {
        visitors.stream()
                .filter(visitor -> isNotUserFriend(userFriendList, visitor))
                .forEach(visitor -> addScore(recommendedFriendList, visitor, 1));
    }

    private static boolean isNotUserFriend(List<String> userFriendList, String name) {
        return !userFriendList.contains(name);
    }

    private static List<String> findNames(Map<String, Integer> recommendedFriendList) {
        List<RecommendedFriend> collect = recommendedFriendList.keySet()
                .stream()
                .map(name -> createRecommendedFriend(name, recommendedFriendList))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        return filterByLimitSize(collect);
    }

    private static RecommendedFriend createRecommendedFriend(String name, Map<String, Integer> recommendedFriendList) {
        return new RecommendedFriend(name, recommendedFriendList.get(name));
    }

    private static List<String> filterByLimitSize(List<RecommendedFriend> content) {
        return content.stream()
                .map(RecommendedFriend::getName)
                .limit(LIMIT_SIZE)
                .collect(Collectors.toList());
    }
}
