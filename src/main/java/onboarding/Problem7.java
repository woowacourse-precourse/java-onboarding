package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // HashMap에 아이디 & 점수 초기화
        HashMap<String, Integer> recommendFds = initRecommendFriends(friends, visitors);

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
}