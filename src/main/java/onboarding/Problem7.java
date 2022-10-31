package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // HashMap에 아이디 & 점수 초기화
        HashMap<String, Integer> recommendFds = initRecommendFriends(friends, visitors);

        // user와 이미 친구인 사람들 목록
        Set<String> alreadyFds = getAlreadyFriends(user, friends);

        return answer;
    }

    public static HashMap<String, Integer> initRecommendFriends(List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> recommendFds = new HashMap<>();

        for (List<String> friend : friends) {
            recommendFds.put(friend.get(0), 0);
            recommendFds.put(friend.get(1), 0);
        }
        for (String visitor : visitors) recommendFds.put(visitor, 0);

        return recommendFds;
    }

    public static Set<String> getAlreadyFriends(String user, List<List<String>> friends) {
        Set<String> alreadyFds = new HashSet<>();

        for (List<String> fd : friends) {
            String id1 = fd.get(0);
            String id2 = fd.get(1);

            if (id1.equals(user)) alreadyFds.add(id2);
            else if (id2.equals(user)) alreadyFds.add(id1);
        }

        return alreadyFds;
    }
}