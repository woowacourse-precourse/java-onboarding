package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * 추천 점수대로 친구를 추천합니다.
     * @param user 추천 친구를 조회할 유저 ID 입니다.
     * @param friends 친구 관계가 포함된 배열입니다.
     * @param visitors 타임라인을 방문한 유저의 배열입니다.
     * @return 추천할 친구의 배열입니다.
     */
    private static List<String> recommendFriends(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> friendGraph = getFriendGraph(friends);
        HashMap<String, Integer> friendPoints = new HashMap<>();
        HashSet<String> notToAdd = new HashSet<>(friendGraph.get(user));
        notToAdd.add(user);

        add10points(user, friendGraph, friendPoints, notToAdd);
        add1point(visitors, friendPoints, notToAdd);
        List<String> sortedList = sortByPointAndId(friendPoints);

        return Collections.emptyList();
    }

    private static HashMap<String, List<String>> getFriendGraph(List<List<String>> friends) {
        return new HashMap<>();
    }

    private static void add10points(String user,
                               HashMap<String, List<String>> friendGraph,
                               HashMap<String, Integer> friendPoints,
                               HashSet<String> notToAdd) {
        return;
    }

    private static void add1point(List<String> visitors,
                                  HashMap<String, Integer> friendPoints,
                                  HashSet<String> notToAdd) {
        return;
    }

    private static List<String> sortByPointAndId(HashMap<String, Integer> friendPoints) {
        return Collections.emptyList();
    }

    /**
     * Problem7의 솔루션 코드입니다.
     * @param user 추천 친구를 조회할 유저 ID 입니다.
     * @param friends 친구 관계가 포함된 배열입니다.
     * @param visitors 타임라인을 방문한 유저의 배열입니다.
     * @return 추천할 친구의 배열입니다.
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = recommendFriends(user, friends, visitors);
        return answer;
    }
}
