package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    private static final int VISIT_SCORE = 1;
    private static final int FRIEND_SCORE = 10;
    private static final int MAX_RECOMMEND = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsInfo = setFriendsInfo(friends);
        Map<String, Integer> score = new HashMap<>();

        addVisitorScore(score, visitors);
        addFriendScore(score, user, friendsInfo);
        removeUserFriendScore(score, friendsInfo.get(user));

        answer = setRecommendFriend(score);
        return answer;
    }

    private static Map<String, List<String>> setFriendsInfo(List<List<String>> friends) {
        Map<String, List<String>> friendsInfo = new HashMap<>();

        for (List<String> relationship : friends) {
            String[] users = {relationship.get(0), relationship.get(1)};

            for (int i = 0; i < users.length; i++) {
                List<String> friendList = friendsInfo.getOrDefault(users[i], new ArrayList<>());
                friendList.add(users[(i + 1) % 2]);

                friendsInfo.put(users[i], friendList);
            }
        }

        return friendsInfo;
    }

    private static void addVisitorScore(Map<String, Integer> score, List<String> visitors) {
        for (String visitor : visitors) {
            score.put(visitor, score.getOrDefault(visitor, 0) + VISIT_SCORE);
        }
    }

    private static void addFriendScore(Map<String, Integer> score, String user, Map<String, List<String>> friendsInfo) {

        for (String userFriend : friendsInfo.get(user)) {
            for (String maybeFriend : friendsInfo.get(userFriend)) {

                if (!maybeFriend.equals(user)) {
                    score.put(maybeFriend, score.getOrDefault(maybeFriend, 0) + FRIEND_SCORE);
                }
            }
        }

    }

    private static void removeUserFriendScore(Map<String, Integer> score, List<String> userFriends) {
        for (String userFriend : userFriends) {
            score.remove(userFriend);
        }
    }

    private static List<String> setRecommendFriend(Map<String, Integer> score) {
        List<String> recommendFriends = new ArrayList<>(score.keySet());

        recommendFriends.sort((user1, user2) -> {
            Integer[] scores = {score.get(user1), score.get(user2)};

            if (scores[0].equals(scores[1])) {
                return user1.compareTo(user2);
            }

            return scores[1].compareTo(scores[0]);
        });

        return recommendFriends.subList(0, Math.min(recommendFriends.size(), MAX_RECOMMEND));
    }

}
