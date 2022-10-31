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

        return sortedList;
    }

    /**
     * 해시맵에 키값이 존재 한다면 밸류값을 리스트에 더하고, 없다면 밸류값이 든 리스트를 만들어 키값에 부여해줍니다.
     *
     * @param key 조회할 키값입니다.
     * @param value 넣을 밸류값입니다.
     * @param hashMap 넣어줄 해시맵입니다.
     */
    private static void addToHashMap(String key, String value, HashMap<String, List<String>> hashMap) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key)
                    .add(value);
            return;
        }
        hashMap.put(key, new ArrayList<>(List.of(value)));
    }

    /**
     * 친구 관계를 토대로 그래프를 만듭니다.
     *
     * @param friends 친구 관계를 포함한 배열입니다.
     * @return 친구 관계 그래프입니다.
     */
    private static HashMap<String, List<String>> getFriendGraph(List<List<String>> friends) {
        HashMap<String, List<String>> friendGraph = new HashMap<>();
        for (List<String> users: friends) {
            String userA = users.get(0);
            String userB = users.get(1);
            addToHashMap(userA, userB, friendGraph);
            addToHashMap(userB, userA, friendGraph);
        }
        return friendGraph;
    }

    /**
     * 나 혹은 내 친구가 아니라면 친구 점수를 더합니다.
     *
     * @param point 더할 점수입니다.
     * @param otherUser 친구 점수를 더할 유저입니다.
     * @param friendPoints 친구 점수 해시맵입니다.
     * @param notToAdd 나와 내 친구를 포함한 해시셋입니다.
     */
    private static void addPoint(int point,
                                  String otherUser,
                                  HashMap<String, Integer> friendPoints,
                                  HashSet<String> notToAdd) {
        if (notToAdd.contains(otherUser)) {
            return;
        }
        int updatedPoint = friendPoints.get(otherUser) + point;
        friendPoints.put(otherUser, updatedPoint);
    }

    /**
     * 친구의 친구에게 친구 점수를 10점 부여합니다.
     *
     * @param user 내 ID 입니다.
     * @param friendGraph 친구 관계 그래프입니다.
     * @param friendPoints 친구 점수 해시맵입니다.
     * @param notToAdd 나와 내 친구를 포함한 해시셋입니다.
     */
    private static void add10points(String user,
                               HashMap<String, List<String>> friendGraph,
                               HashMap<String, Integer> friendPoints,
                               HashSet<String> notToAdd) {
        for (String myFriend: friendGraph.get(user)) {
            for (String friendFriend: friendGraph.get(myFriend)) {
                addPoint(10, friendFriend, friendPoints, notToAdd);
            }
        }
    }

    /**
     * 타임라인 방문자들에게 친구 점수를 1점을 부여합니다.
     * @param visitors 방문자 ID 배열입니다.
     * @param friendPoints 친구 점수 해시맵입니다.
     * @param notToAdd 나와 내 친구를 포함한 해시셋입니다.
     */
    private static void add1point(List<String> visitors,
                                  HashMap<String, Integer> friendPoints,
                                  HashSet<String> notToAdd) {
        for (String visitor: visitors) {
            addPoint(1, visitor, friendPoints, notToAdd);
        }
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
