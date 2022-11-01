package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendFriendScoreMap = new HashMap<>(friends.size() * 2);
        initRecommendFriendScoreMap(recommendFriendScoreMap, friends, visitors);

        Map<String, List<String>> friendListMap = getFriendListMap(friends, recommendFriendScoreMap.keySet());

        updateRecommendFriendScoreByFriendList(recommendFriendScoreMap, friendListMap, user);
        updateRecommendFriendScoreByVisitorList(recommendFriendScoreMap, visitors);

        return getRecommendedFriendList(recommendFriendScoreMap, friendListMap, user);
    }

    private static void initRecommendFriendScoreMap(Map<String, Integer> recommendFriendScoreMap, List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            recommendFriendScoreMap.put(friend.get(0), 0);
            recommendFriendScoreMap.put(friend.get(1), 0);
        }

        for (String visitor : visitors) {
            recommendFriendScoreMap.put(visitor, 0);
        }
    }

    private static Map<String, List<String>> getFriendListMap(List<List<String>> friends, Set<String> friendSet) {
        Map<String, List<String>> friendListMap = new HashMap<>();

        for (String friend : friendSet) {
            friendListMap.put(friend, new ArrayList<>());
        }

        List<String> friendList;
        for (List<String> friend : friends) {
            friendList = friendListMap.get(friend.get(0));
            friendList.add(friend.get(1));
            friendList = friendListMap.get(friend.get(1));
            friendList.add(friend.get(0));
        }

        return friendListMap;
    }

    private static List<String> getRecommendedFriendList(Map<String, Integer> recommendFriendScoreMap, Map<String, List<String>> friendListMap, String user) {
        recommendFriendScoreMap.remove(user);

        for (String friendOfUser : friendListMap.get(user)) {
            recommendFriendScoreMap.remove(friendOfUser);
        }

        return recommendFriendScoreMap.entrySet().stream()
                .filter(nameScoreEntry -> nameScoreEntry.getValue() > 0)
                .sorted((nameScoreEntry1, nameScoreEntry2) -> {
                    int score1 = nameScoreEntry1.getValue();
                    int score2 = nameScoreEntry2.getValue();

                    int scoreCompareResult = -Integer.compare(score1, score2);
                    if (scoreCompareResult != 0) {
                        return scoreCompareResult;
                    }

                    String name1 = nameScoreEntry1.getKey();
                    String name2 = nameScoreEntry2.getKey();

                    return name1.compareTo(name2);
                })
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static void updateRecommendFriendScoreByVisitorList(Map<String, Integer> recommendFriendScoreMap, List<String> visitors) {
        updateRecommendFriendScore(recommendFriendScoreMap, visitors, 1);
    }

    private static void updateRecommendFriendScoreByFriendList(Map<String, Integer> recommendFriendScoreMap, Map<String, List<String>> friendListMap, String user) {
        for (String friendOfUser : friendListMap.get(user)) {
            List<String> friendListOfFriend = friendListMap.get(friendOfUser);
            updateRecommendFriendScore(recommendFriendScoreMap, friendListOfFriend, 10);
        }
    }

    private static void updateRecommendFriendScore(Map<String, Integer> recommendFriendScoreMap, List<String> friendListOfFriend, int scoreUpdateAmount) {
        for (String friend : friendListOfFriend) {
            recommendFriendScoreMap.compute(friend, (name, score) -> score + scoreUpdateAmount);
        }
    }

}
