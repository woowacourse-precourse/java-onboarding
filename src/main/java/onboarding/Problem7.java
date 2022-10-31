package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
}
