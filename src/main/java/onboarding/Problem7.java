package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getFriendsOfUser(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>(List.of());
        for (List<String> relation : friends) {
            String userA = relation.get(0);
            String userB = relation.get(1);

            if (userA.equals(user)) {
                friendsOfUser.add(userB);
            } else if (userB.equals(user)) {
                friendsOfUser.add(userA);
            }
        }
        return friendsOfUser;
    }

    public static List<String> getRecommendFriends(String user, List<List<String>> friends, List<String> visitors) {
        List<String> recommendFriends = new ArrayList<>(List.of());

        List<String> friendsOfUser = getFriendsOfUser(user, friends);

        for (List<String> relation : friends) {
            String userA = relation.get(0);
            String userB = relation.get(1);

            if (!(friendsOfUser.contains(userA) || userA.equals(user)))
                recommendFriends.add(userA);
            if (!(friendsOfUser.contains(userB) || userB.equals(user)))
                recommendFriends.add(userB);
        }

        for (String visitor : visitors) {
            if (!(friendsOfUser.contains(visitor)))
                recommendFriends.add(visitor);
        }

        return new ArrayList<>(new HashSet<>(recommendFriends));
    }

    public static HashMap<String, Integer> getScoreKnownFriend(String user, List<List<String>> friends) {
        HashMap<String, Integer> scoreKnownFriend = new HashMap<String, Integer>();

        List<String> friendsOfUser = getFriendsOfUser(user, friends);
        List<String> recommendFriends = getRecommendFriends(user, friends, List.of());

        for (List<String> relation : friends) {
            String userA = relation.get(0);
            String userB = relation.get(1);

            if (recommendFriends.contains(userA) && friendsOfUser.contains(userB))
                if (scoreKnownFriend.containsKey(userA)) {
                    int score = scoreKnownFriend.get(userA);
                    scoreKnownFriend.put(userA, score + 10);
                } else
                    scoreKnownFriend.put(userA, 10);

            if (recommendFriends.contains(userB) && friendsOfUser.contains(userA))
                if (scoreKnownFriend.containsKey(userB)) {
                    int score = scoreKnownFriend.get(userB);
                    scoreKnownFriend.put(userB, score + 10);
                } else
                    scoreKnownFriend.put(userB, 10);
        }

        return scoreKnownFriend;
    }

    public static HashMap<String, Integer> getScoreVisitFriend(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreVisitFriend = new HashMap<String, Integer>();

        List<String> recommendFriends = getRecommendFriends(user, friends, visitors);

        for (String visitor : visitors) {
            if (recommendFriends.contains(visitor)) {
                if (scoreVisitFriend.containsKey(visitor)) {
                    int score = scoreVisitFriend.get(visitor);
                    scoreVisitFriend.put(visitor, score + 1);
                } else {
                    scoreVisitFriend.put(visitor, 1);
                }
            }
        }

        return scoreVisitFriend;
    }

    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> List<K> sortAndSlicingFriends(
            HashMap<K, V> scoreOfFriends
    ) {
        List<K> friends = new ArrayList<>(List.of());
        List<Map.Entry<K, V>> entrySetOfMap = new LinkedList<>(scoreOfFriends.entrySet());
        entrySetOfMap.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return o1.getKey().compareTo(o2.getKey());
            else
                return o2.getValue().compareTo(o1.getValue());
        });

        for (Map.Entry<K, V> entry : entrySetOfMap) {
            friends.add(entry.getKey());
            if (friends.size() == 5)
                break;
        }

        return friends;
    }
}
