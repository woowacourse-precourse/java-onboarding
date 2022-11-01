/*
 * 우테코 1주차 프리코스 미션 - 문제 7
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM7.md]
 *
 */
package onboarding;

import java.util.List;
import java.util.*;

/**
 * isFriend : user의 친구
 * getScore : 점수 부여
 * isAcrossFriend : user의 친구의 친구 (함께 아는 친구) (건너친구)
 * checkVisitor : 방문자 확인
 * recommendFriends : 점수를 바탕으로 최대 5명의 친구 추천
 **/

public class Problem7 {
    static List<String> userFriend;
    static List<String> acrossFriends;
    static Map<String, Integer> scoreList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        userFriend = new ArrayList<>();
        acrossFriends = new ArrayList<>();
        scoreList = new TreeMap<>();

        isFriend(user, friends);
        isAcrossFriend(user, friends);
        checkVisitor(user, visitors);

        answer = recommendFriends(scoreList);

        return answer;
    }

    /** user의 친구 **/
    private static void isFriend(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriend.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriend.add(friend.get(0));
            }
        }
    }

    /** 점수 부여 **/
    private static void getScore(String person, int score) {
        scoreList.put(person, scoreList.getOrDefault(person, 0) + score);
    }

    /** user의 친구의 친구(user와 함께 아는 친구) **/
    private static void isAcrossFriend(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            /* user일 경우 예외 */
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                continue;
            }
            /* user의 친구일 경우 예외 */
            if (userFriend.contains(friend.get(0)) && userFriend.contains(friend.get(1))) {
                continue;
            }

            /* 위 예외사항 제외하고 user친구 목록에 포함되는 사람이 있다면, 다른 한 명을 함께아는 친구목록(acrossFriends)에 추가 + 10점 부여 */
            if (userFriend.contains(friend.get(0))) {
                acrossFriends.add(friend.get(1));
                getScore(friend.get(1), 10);
            } else if (userFriend.contains(friend.get(1))) {
                acrossFriends.add(friend.get(0));
                getScore(friend.get(0), 10);
            }
        }
    }

    /** 방문자 확인 **/
    private static void checkVisitor(String user, List<String> visitors) {
        for (String visitor : visitors) {
            /* user가 아니며, user친구 목록에 없는 사람 */
            if (!user.equals(visitor) && !userFriend.contains(visitor)) {
                getScore(visitor, 1);
            }
        }
    }

    /** 친구 추천 **/
    private static List<String> recommendFriends(Map<String, Integer> scoreList) {
        List<String> answer = new ArrayList<>();
        LinkedList<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreList.entrySet());

        entryList.sort((s1, s2) -> s1.getValue() == s2.getValue() ?
                s1.getKey().compareTo(s2.getKey()) : s2.getValue() - s1.getValue());

        /* 최대 5명 return */
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            if (cnt == 5) {
                break;
            }
            //추천점수가 0이 아닌 경우
            if (entry.getValue() != 0) {
                answer.add(entry.getKey());
                cnt++;
            }
        }

        return answer;
    }
}