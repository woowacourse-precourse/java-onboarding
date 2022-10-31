package onboarding.problem7;

import java.util.*;

public class FriendRecommender {

    public static List<String> getRecommendFriends(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = new ArrayList<>();
        List<List<String>> anotherRelation = new ArrayList<>();
        HashMap<String, Integer> recommendList = new HashMap<>();

        for (List<String> friend : friends) {
            separateFriends(friend,user,userFriends,anotherRelation);
        }

        for (List<String> anotherFriend : anotherRelation) {
            if (isValidRelation(userFriends,anotherFriend)) {
                addknowTogetherPoint(getRecommendFriend(userFriends,anotherFriend), recommendList);
            }
        }

        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                addPoint(visitor, 1,recommendList);
            }
        }

        return new ArrayList<>();
    }

    private static void separateFriends(List<String> friendship, String user, List<String> userFriends, List<List<String>> anotherRelation) {
        if (friendship.contains(user)) {
            Integer index = getIndex(friendship,user);
            userFriends.add(friendship.get(index));
            return;
        }
        anotherRelation.add(friendship);
    }

    private static Integer getIndex(List<String> userFriendList, String separationTarget) {
        return userFriendList.indexOf(separationTarget) == 0 ? 1 : 0;
    }

    private static boolean isValidRelation(List<String> userFriends, List<String> anotherFriend)     {
        if (userFriends.contains(anotherFriend.get(0)) && userFriends.contains(anotherFriend.get(1))) {
            return false;
        }

        if (!userFriends.contains(anotherFriend.get(0)) && !userFriends.contains(anotherFriend.get(1))) {
            return false;
        }
        return true;
    }

    private static String getRecommendFriend(List<String> userFriends, List<String> anotherFriend) {
        if (userFriends.contains(anotherFriend.get(0))) {
            return anotherFriend.get(1);
        }
        return anotherFriend.get(0);
    }

    private static void addknowTogetherPoint(String unknownFriend, HashMap<String, Integer> recommendList) {
        addPoint(unknownFriend,10, recommendList);
    }

    private static void addPoint(String recommendFriend, Integer point, HashMap<String, Integer> recommendList) {
        if (recommendList.containsKey(recommendFriend)) {
            recommendList.put(recommendFriend,recommendList.get(recommendFriend)+point);
        }

        if (!recommendList.containsKey(recommendFriend)) {
            recommendList.put(recommendFriend,point);
        }
    }
}
