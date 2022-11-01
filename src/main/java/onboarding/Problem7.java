package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> recommendFriend(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relationship = new HashMap<>();
        // 사람 목록 만들기 (relationship)
        String name;
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                name = (friends.get(i)).get(j);
                if (!relationship.containsKey(name)) {
                    relationship.put(name, new ArrayList<>());
                }
            }
        }
        // 점수 목록 만들기 (score)
        Map<String, Integer> score = new HashMap<>();
        for (int i = 0; i < relationship.size(); i++) {
            score.put(relationship.get(i).get(0), 0);
        }
        // 사람마다 친구인 사람을 나타내는 map
        for (int i = 0; i < friends.size(); i++) {
            String firstName = friends.get(i).get(0);
            String secondName = friends.get(i).get(1);
            relationship.get(firstName).add(secondName);
            relationship.get(secondName).add(firstName);
        }
        // 방문한 횟수에 따른 점수 추가
        for (String visitor : visitors) {
            if (score.containsKey(visitor)) {
                score.put(visitor, score.get(visitor) + 1);
            } else {
                score.put(visitor, 1);
            }
        }




    }

}
