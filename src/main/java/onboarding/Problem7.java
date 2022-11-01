package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> closeFriends = new ArrayList<>();
        Map<String, Integer> friendScore = new HashMap<String, Integer>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                closeFriends.add(friends.get(i).get(0));
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < closeFriends.size(); j++) {
                if (friends.get(i).contains(closeFriends.get(j)) && !friends.get(i).contains(user)) {
                    if (friendScore.containsKey(friends.get(i).get(1))) {
                        friendScore.put(friends.get(i).get(1), friendScore.get(friends.get(i).get(1)) + 5);
                    }else {
                        friendScore.put(friends.get(i).get(1), 5);
                    }
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (!closeFriends.contains(visitors.get(i))) {
                if (friendScore.containsKey(visitors.get(i))) {
                    friendScore.put(visitors.get(i), friendScore.get(visitors.get(i)) + 1);
                }else {
                    friendScore.put(visitors.get(i), 1);
                }
            }
        }

        List<String> recommendFriend = new ArrayList<>(friendScore.keySet());
        Collections.sort(recommendFriend);
        recommendFriend.sort((o1, o2) -> friendScore.get(o2).compareTo(friendScore.get(o1)));

        if (recommendFriend.size() > 5) {
            recommendFriend = recommendFriend.subList(0, 5);
        }

        return recommendFriend;
    }
}
