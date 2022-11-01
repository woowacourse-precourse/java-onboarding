package onboarding;

import java.util.*;

public class Problem7 {
    /**
     * 기능
     * 1. 사용자와 추천 점수를 저장하는 friendScore
     * 2. friendScore에 사용자의 친구와 친구의 친구, 방문자 정보를 모두 저장
     * 3. 사용자의 친구를 확인하고 친구의 친구의 친구를 friendOfFriend 리스트에 저장
     * 4. firendOfFriend와 visitor 리스트를 활용해 추천 점수 계산
     * 5. 추천 점수가 높은 순으로 정렬 후 반환
     *
     * @param user 추천을 받고자 하는 사용자
     * @param friends 사용자의 친구와 친구의 친구 정보 리스트
     * @param visitors 사용자의 타임라인을 방문한 사람 리스트
     * @return 최대 5명의 추천 친구 리스트
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendScore = new HashMap<>();
        friendScore = initUserMap(friendScore, friends, visitors);
        List<String> userFriend = findUserFriend(user, friends);
        List<String> friendOfFriend = getFriendOfFriend(userFriend, friends);
        friendScore = getScore(friendOfFriend, visitors, friendScore);
        return getRecommendFriends(friendScore, user, userFriend);
    }

    /**
     * Map에 사용자와 관련된 사용자들의 정보를 추가하는 method
     *
     * @param map 사용자와 관련 있는 사용자들의 정보(key)와 추천 점수(value)
     * @param friends 사용자의 친구 정보
     * @param visitors 사용자의 타임라인을 방문한 사용자
     * @return map
     */
    public static Map<String, Integer> initUserMap(Map<String, Integer> map, List<List<String>> friends, List<String> visitors) {
        for (List<String> friend: friends) {
            map.put(friend.get(0), 0);
            map.put(friend.get(1), 0);
        }
        for (String visitor: visitors) {
            map.put(visitor, 0);
        }
        return map;
    }

    /**
     * 사용자와 친구 관계인 사용자를 찾는 method
     *
     * @param user 사용자
     * @param friends 사용자와 관련된 사용자들의 리스트
     * @return 사용자와 친구관계인 회원 리스트
     */
    public static List<String> findUserFriend(String user, List<List<String>>friends) {
        List<String> userFriend = new ArrayList<>();

        for(List<String> friend: friends) {
            if (friend.get(0).equals(user)) userFriend.add(friend.get(1));
            if (friend.get(1).equals(user)) userFriend.add(friend.get(0));
        }
        return userFriend;
    }

    /**
     * 친구의 친구(함께 아는 친구)를 찾는 method
     *
     * @param userFriend 사용자의 친구 리스트
     * @param friends 사용자와 관련된 회원 리스트
     * @return 함께 아는 친구 리스트
     */
    public static List<String> getFriendOfFriend(List<String> userFriend, List<List<String>> friends) {
        List<String> friendOfFriend = new ArrayList<>();

        for (List<String> friend: friends){
            for (String myFriend: userFriend) {
                if (friend.get(0).equals(myFriend)) friendOfFriend.add(friend.get(1));
                if (friend.get(1).equals(myFriend)) friendOfFriend.add(friend.get(0));
            }
        }
        return friendOfFriend;
    }

    /**
     * 추천 점수를 계산하는 method
     * @param friendOfFriend 사용자와 친구가 함께아는 친구 리스트
     * @param visitors 사용자의 타임라인에 방문한 회원 리스트
     * @param friendScore 사용자와 관련된 회원(key)과 추천 점수(value)
     * @return 회원과 추천 점수가 저장된 map
     */
    public static Map<String, Integer> getScore(List<String> friendOfFriend, List<String> visitors, Map<String, Integer> friendScore) {
        for (String friend: friendOfFriend) {
            int prevScore = friendScore.get(friend);
            friendScore.put(friend, prevScore+10);
        }
        for (String visitor: visitors) {
            int prevScore = friendScore.get(visitor);
            friendScore.put(visitor, prevScore+1);
        }
        return friendScore;
    }

    /**
     * 추천 점수가 높은 5명을 구하는 method
     * @param friendScore 사용자와 관련된 회원(key)과 추천 점수(value)
     * @param user 사용자
     * @param userFriend 사용자와 친구관계인 회원
     * @return 추천 점수가 높은 회원 5명의 리스트
     */
    public static List<String> getRecommendFriends(Map<String, Integer> friendScore, String user, List<String> userFriend) {
        friendScore.remove(user);
        for (String friend: userFriend) friendScore.remove(friend);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(friendScore.entrySet());
        List<String> recommendFriends = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            if (i == 5) break;
            recommendFriends.add(entry.getKey());
            i++;
        }
        return recommendFriends;
    }
}