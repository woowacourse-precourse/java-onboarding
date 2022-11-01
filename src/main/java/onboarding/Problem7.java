package onboarding;

import java.util.*;

public class Problem7 {
    private static final int FIRST_ID = 0;
    private static final int SECOND_ID = 1;
    private static final int ZERO_SCORE = 0;
    private static final int VISIT_SCORE = 1;
    private static final int SAME_FRIEND_SCORE = 10;

    private static Map<String, List<String>> friendsMap = new TreeMap<>();
    private static Map<String, Integer> scoreMap = new TreeMap<>();
    private static List<RecommendFriend> recommendFriendList = new ArrayList<>();

    static class RecommendFriend {
        private String id;
        private int score;

        RecommendFriend(String id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeFriendMapOfFriendsList(friends);
        makeScoreMapOfAllId(user, visitors);
        removeFriendsAlreadyKnow(friendsMap.get(user));
        removeZeroScoreFriends();
        scoreMap.remove(user);
        makeRecommendFriendList();
        sortRecommendFriendList();
        return createSortedIdList();
    }

    public static void sortRecommendFriendList() {
        recommendFriendList.sort((o1, o2) -> {
            if (o1.score == o2.score) {
                return o1.id.compareTo(o2.id);
            }
            return o2.score - o1.score;
        });
    }

    public static List<String> createSortedIdList() {
        int count = 0;
        List<String> idList = new ArrayList<>();
        for (RecommendFriend recommendFriend : recommendFriendList) {
            idList.add(recommendFriend.id);
            count++;
            if (count >= 5) {
                break;
            }
        }
        return idList;
    }

    public static void makeRecommendFriendList() {
        scoreMap.keySet()
                .forEach(key -> recommendFriendList.add(new RecommendFriend(key, scoreMap.get(key))));
    }

    public static void removeZeroScoreFriends() {
        recommendFriendList.forEach(friend -> {
            if (friend.score == 0) {
                recommendFriendList.remove(friend);
            }
        });
    }

    public static void removeFriendsAlreadyKnow(List<String> userFriendList) {
        userFriendList.forEach(userFriend -> scoreMap.remove(userFriend));
    }

    public static void makeScoreMapOfAllId(String user, List<String> visitors) {
        List<String> userFriendList = friendsMap.get(user);
        friendsMap.keySet()
                .forEach(key -> scoreMap.put(key, scoreMap.getOrDefault(key, ZERO_SCORE) + calcSameFriendsScore(userFriendList, key)));
        visitors.forEach(visitor -> scoreMap.put(visitor, scoreMap.getOrDefault(visitor, ZERO_SCORE) + VISIT_SCORE));
    }

    public static int calcSameFriendsScore(List<String> userFriendList, String key) {
        return SAME_FRIEND_SCORE * getCountOfSameFriends(friendsMap.get(key), userFriendList);
    }

    public static int getCountOfSameFriends(List<String> someoneFriendList, List<String> userFriendList) {
        int count = 0;
        for (String someone : someoneFriendList) {
            if (userFriendList.contains(someone)) {
                count++;
            }
        }
        return count;
    }

    public static void makeFriendMapOfFriendsList(List<List<String>> friends) {
        friends.forEach(twoFriends -> {
            putToFriendsMap(twoFriends.get(FIRST_ID), twoFriends.get(SECOND_ID));
            putToFriendsMap(twoFriends.get(SECOND_ID), twoFriends.get(FIRST_ID));
        });
    }

    public static void putToFriendsMap(String key, String valueOfList) {
        if (friendsMap.containsKey(key)) {
            friendsMap.get(key).add(valueOfList);
            return;
        }
        ArrayList<String> valueList = new ArrayList<>();
        valueList.add(valueOfList);
        friendsMap.put(key, valueList);
    }

}
