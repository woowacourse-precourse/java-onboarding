package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Set<String>> friendsMap = new HashMap<>();
        HashMap<String, Integer> recommendScore = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);

            Set<String> aFriends = friendsMap.getOrDefault(a, new HashSet<>());
            Set<String> bFriends = friendsMap.getOrDefault(b, new HashSet<>());

            aFriends.add(b);
            bFriends.add(a);

            friendsMap.put(a, aFriends);
            friendsMap.put(b, bFriends);
        }

        // 함께 아는 친구 점수
        Set<String> userFriends = friendsMap.get(user);
        for (String friend: userFriends) {
            Set<String> recommendFriends = friendsMap.get(friend);
            recommendFriends.remove(user);

            for (String recommendFriend : recommendFriends) {
                recommendScore.put(recommendFriend, recommendScore.getOrDefault(recommendFriend, 0) + 10);
            }
        }

        // 방문 횟수 점수
        for (String visitor : visitors) {
            recommendScore.put(visitor, recommendScore.getOrDefault(visitor, 0) + 1);
        }

        return answer;
    }


}
