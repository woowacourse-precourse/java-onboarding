package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 함께 아는 친구의 수 - 10점
* 사용자의 타임라이넹 방문한 횟수 - 1점
*
* 사용자 user, 친구 관계 정보 friends, 방문기록 visitors
* 점수 높은순 5명 반환, 0점은 리턴하지 않는다.
*
* [A,B] A와 B는 친구이며, 중복해서 주어지지 않고, 추천할 친구가 없는 경우 주어지지 않는다.
*
*/
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    // HashMap으로 name, value로 초기화한다.
    public Map<String, Integer> initScore(List<List<String>> friends) {
        Map<String, Integer> initScore = new HashMap<>();
        return initScore;
    }



}
