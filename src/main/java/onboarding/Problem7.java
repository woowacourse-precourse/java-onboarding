package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> userFriends = new ArrayList<>();
    static HashMap<String, Integer> recommendedFriends = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendsList;
        for (int i = 0; i < friends.size(); i++) {
            friendsList = friends.get(i);
            findUserFriend(friendsList, user);
        }
        System.out.println(userFriends);

        for (int i = 0; i < friends.size(); i++) {
            friendsList = friends.get(i);
            findRecommendedFriend(friendsList, user);
        }

        for (int i = 0; i < friends.size(); i++) {
            friendsList = friends.get(i);
            plusScore(friendsList);
        }

        Iterator iterator = recommendedFriends.keySet().iterator();
        while (iterator.hasNext()) {
            String recommendFriend = (String) iterator.next();
            if (visitors.contains(recommendFriend)) {
                int score = recommendedFriends.get(recommendFriend);
                recommendedFriends.put(recommendFriend, score + 1);
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            if (!userFriends.contains(visitor)) {
                plusVisitorScore(visitor);
            }
        }
        System.out.println(recommendedFriends);

        TopFiveRecommendedFriends();
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void TopFiveRecommendedFriends() {
        List<String> TopFiveScore = new ArrayList<>(recommendedFriends.keySet());
        TopFiveScore.sort((s1,s2) -> recommendedFriends.get(s2).compareTo(recommendedFriends.get(s1)));
    }

    private static void plusVisitorScore(String visitor) {
        if (recommendedFriends.containsKey(visitor)) {
            int score = recommendedFriends.get(visitor);
            recommendedFriends.put(visitor, score + 1);
        }

        if (!recommendedFriends.containsKey(visitor)) {
            recommendedFriends.put(visitor, 1);
        }
    }

    private static void plusScore(List<String> friendsList) {
        Iterator iterator = recommendedFriends.keySet().iterator();
        while (iterator.hasNext()) {
            String recommendFriend = (String) iterator.next();
            for (int i = 0; i < userFriends.size(); i++) {
                if (friendsList.contains(recommendFriend) && friendsList.contains(userFriends.get(i))) {
                    int score = recommendedFriends.get(recommendFriend);
                    recommendedFriends.put(recommendFriend, score + 10);
                }
            }
        }

    }

    private static void findRecommendedFriend(List<String> friendsList, String user) {
        for (int i = 0; i < userFriends.size(); i++) {
            if (friendsList.contains(userFriends.get(i)) && !friendsList.contains(user)) {
                addRecommendedFriend(friendsList, userFriends.get(i));
            }
        }
    }

    private static void addRecommendedFriend(List<String> friendsList, String userFriend) {
        if (friendsList.indexOf(userFriend) == 0) {
            recommendedFriends.put(friendsList.get(1), 0);
        }

        if (friendsList.indexOf(userFriend) == 1) {
            recommendedFriends.put(friendsList.get(0), 0);
        }
    }

    private static void findUserFriend(List<String> friendsList, String user) {
        if (friendsList.contains(user) && friendsList.indexOf(user) == 0) {
            userFriends.add(friendsList.get(1));
        }

        if (friendsList.contains(user) && friendsList.indexOf(user) == 1) {
            userFriends.add(friendsList.get(0));
        }
    }
}
