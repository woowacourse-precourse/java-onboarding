package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static List<String> recommendFriends(String user, List<List<String>> friends, List<String> visitors) {
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
