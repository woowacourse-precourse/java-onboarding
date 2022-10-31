package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능 구현 목록
 * 1. user의 친구들 얻기
 * 2. user친구의 친구들 얻기.
 *  2.1 Key: user친구, Value: user친구의 친구들
 * 3. user친구의 친구들 순회 하면서 friendScore 합산
 *  3.1 단 user친구는 friendScore에 포함하지 않는다.
 * 4. visitors 순회 하면서 visitorScore 합산
 *  4.1 단 user친구는 visitorScore에 포함하지 않는다.
 * 5. friendScore, visitorScore 병합
 * 6. Score 내림차순 정렬 후 이름 오름차순 정렬
 *  6.1 최대 5명 return
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
