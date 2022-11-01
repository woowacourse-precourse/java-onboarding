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
        List<String> answer = Collections.emptyList();

        userFriend = new ArrayList<>();
        acrossFriends = new ArrayList<>();
        scoreList = new TreeMap<>();

        isFriend(user, friends);
        isAcrossFriend(user, friends);
        checkVisitor(user, visitors);

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

            /* 위 예외사항 제외하고 user친구 목록에 포함되는 사람이 있다면, 다른 한 명을 함께아는 친구목록(acrossFriends)에 추가 */
            if (userFriend.contains(friend.get(0))) {
                acrossFriends.add(friend.get(1));
                getScore(friend.get(1), 10);
            } else if (userFriend.contains(friend.get(1))) {
                acrossFriends.add(friend.get(0));
                getScore(friend.get(0), 10);
            }
        }
    }

    /** 점수 부여 **/
    private static void getScore(String person, int score) {
        scoreList.put(person, scoreList.getOrDefault(person, 0) + score);
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

}