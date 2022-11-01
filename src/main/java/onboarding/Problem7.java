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

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        userFriend = new ArrayList<>();

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

}