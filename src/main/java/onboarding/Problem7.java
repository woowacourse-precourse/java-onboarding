package onboarding;

import java.util.*;

/**
 * @Problem: 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
 */
public class Problem7 {
    /**
     * @Method: recommendFriends
     * 1. 이름을 key, 친구의 이름 List value로 갖는 Map을 만든다.
     * 2. friends의 0, 1 인덱스를 각각 key로 두고, 서로를 value에 추가한다.
     * 3. Name, Point를 각각 key, value로 갖는 Map을 만든다.
     * 4. user의 친구 List에 있는 사람들의 친구(친구의 친구)의 이름을 key에 추가하고, 점수를 10점씩 추가한다.
     * 5 - 1, User 자신과, 이미 친구인 사람은 제외 한다.
     * 6. visitors를 참고하여, 해당하는 사람에게 점수를 1점씩 추가한다.
     * 7. 점수 순서, 동점인 경우, 알파벳 순서로 정렬한다.
     * 8. 최대 상위 5명까지의 이름을 List로 반환한다.
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
