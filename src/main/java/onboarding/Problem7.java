package onboarding;

import java.util.*;

public class Problem7 {
    private static final int FIRST_FRIEND_ID = 0;
    private static final int SECOND_FRIEND_ID = 1;

    private static final int FRIEND_RECOMMENDATION_SCORE = 10;

    private static final int VISITOR_SCORE = 10;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if (!verifyException(user, friends, visitors)) {
            return List.of("Error");
        }

        List<String> userFriends = findUserFriend(user, friends);
        Map<String, Integer> recommendFriend = makeRecommend(user, userFriends, friends, visitors);
        addVisitorScore(recommendFriend, visitors);

        return answer;
    }

    private static boolean verifyException(String user, List<List<String>> friends, List<String> visitors) {
        return (checkUser(user) || checkFriend(friends) || checkVisitor(visitors));
    }

    private static boolean checkUser(String user) {
        return (checkUserLength(user) || isLowerLetter(user));
    }

    private static boolean checkUserLength(String user) {
        return (user != null && user.length() >= 1 && user.length() <= 30);
    }

    private static boolean isLowerLetter(String user) {
        for (char letter : user.toCharArray()) {
            if (Character.isLowerCase(letter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkFriend(List<List<String>> friends) {
        return (checkFriendSize(friends.size()) || checkFriendId(friends) || checkDuplicate(friends));
    }

    private static boolean checkFriendSize(int size) {
        return (size >= 1 && size <= 10000);
    }

    private static boolean checkFriendId(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (checkUser(friend.get(FIRST_FRIEND_ID)) || checkUser(friend.get(SECOND_FRIEND_ID))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDuplicate(List<List<String>> friends) {
        Set<List<String>> friendsSet = new HashSet<>();

        for (List<String> friend : friends) {
            if (friendsSet.contains(friends)) {
                return false;
            }
            friendsSet.add(friend);
        }
        return true;
    }

    private static boolean checkVisitor(List<String> visitors) {
        return (checkVisitorSize(visitors.size()) || checkVisitorId(visitors));
    }

    private static boolean checkVisitorSize(int size) {
        return (size >= 0 && size <= 10000);
    }

    private static boolean checkVisitorId(List<String> visitors) {
        for (String visitor : visitors) {
            if (!checkUser(visitor)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> findUserFriend(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friendship : friends) {
            if (friendship.contains(user)) {
                userFriends.add(getFriend(user, friendship.get(FIRST_FRIEND_ID), friendship.get(SECOND_FRIEND_ID)));
            }
        }
        return userFriends;
    }

    private static String getFriend(String user, String firstId, String secondId) {
        if (user.equals(firstId)) {
            return secondId;
        }
        return firstId;
    }

    private static Map<String, Integer> makeRecommend(String user, List<String> userFriends ,List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendFriend = new HashMap<>();
        String recommendId = "";

        for (List<String> friend : friends) {
            for (String userFriend : userFriends) {
                if (friend.contains(userFriend) && !friend.contains(user)) {
                    recommendId = getFriend(userFriend, friend.get(FIRST_FRIEND_ID), friend.get(SECOND_FRIEND_ID));
                    recommendFriend.put(recommendId, getScore(recommendId, recommendFriend) + FRIEND_RECOMMENDATION_SCORE);
                }
            }
        }
        return recommendFriend;
    }

    private static int getScore(String Id, Map<String, Integer> recommedFriend) {
        if (recommedFriend.containsKey(Id)) {
            return (recommedFriend.get(Id));
        }
        return (0);
    }

    private static void addVisitorScore(Map<String, Integer> recommendFriend, List<String> visitors) {
        for (String visitor : visitors) {
            if (recommendFriend.containsKey(visitor)) {
                recommendFriend.put(visitor, getScore(visitor, recommendFriend) + VISITOR_SCORE);
            }
        }
    }

}