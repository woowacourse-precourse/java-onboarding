package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> recommendFriend(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relationship = new HashMap<>();
        // 사람 목록 만들기
        String name;
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                name = (friends.get(i)).get(j);
                if (!relationship.containsKey(name)) {
                    relationship.put(name, new ArrayList<>());
                }
            }
        }
        // 사람마다 친구인 사람을 나타내는 map
        for (int i = 0; i < friends.size(); i++) {
            String firstName = friends.get(i).get(0);
            String secondName = friends.get(i).get(1);
            relationship.get(firstName).add(secondName);
            relationship.get(secondName).add(firstName);
        }


    }

}
