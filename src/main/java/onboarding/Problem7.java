package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> users = createUserList(friends, visitors);
        List<String> friendsOfUser = createFriendList(user, friends);

        Map<String, Long> recommendScore = new HashMap<>();
        for (String id : users) {
            recommendScore.put(id, 0L);
        }

        for (String id : friendsOfUser) {
            for (List<String> friend : friends) {
                if(friend.get(0) == id && friend.get(1) != user)
                    recommendScore.put(friend.get(1), recommendScore.get(friend.get(1)) + 10);
                if(friend.get(1) == id && friend.get(0) != user)
                    recommendScore.put(friend.get(1), recommendScore.get(friend.get(0)) + 10);
            }
        }

        for (String id : visitors) {
            recommendScore.put(id, recommendScore.get(id) + 1);
        }

        Map<Long, List<String>> recommendFriendList = new HashMap<>();
        for (Long value : recommendScore.values()) {
            if(!recommendFriendList.containsKey(value)) recommendFriendList.put(value, new ArrayList<>());
        }

        for (String id : recommendScore.keySet()) {
            recommendFriendList.get(recommendScore.get(id)).add(id);
            recommendFriendList.put(recommendScore.get(id), recommendFriendList.get(recommendScore.get(id)));
        }

        for (Long score : recommendFriendList.keySet()) {
            Collections.sort(recommendFriendList.get(score));
        }

        List<Long> keySet = new ArrayList<>(recommendFriendList.keySet());
        Collections.sort(keySet, Collections.reverseOrder());

        List<String> recommendFriends = new ArrayList<>();
        for (Long score : keySet) {
            if(score == 0L) break;
            if(recommendFriends.size() == 5) break;

            for (String id : recommendFriendList.get(score)) {
                if(!friendsOfUser.contains(id)) recommendFriends.add(id);
                if(recommendFriends.size() == 5) break;
            }
        }

        return recommendFriends;
    }

    private static List<String> createUserList(List<List<String>> friends, List<String> visitors) {
        List<String> users = new ArrayList<>();

        for (List<String> friend : friends) {
            if(!users.contains(friend.get(0))) users.add(friend.get(0));
            if(!users.contains(friend.get(1))) users.add(friend.get(1));
        }

        for (String visitor : visitors) {
            if(!users.contains(visitor)) users.add(visitor);
        }

        return users;
    }

    private static List<String> createFriendList(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>();

        for (List<String> friend : friends) {
            if(friend.get(0).equals(user)) friendsOfUser.add(friend.get(1));
            if(friend.get(1).equals(user)) friendsOfUser.add(friend.get(0));
        }

        return friendsOfUser;
    }
}
