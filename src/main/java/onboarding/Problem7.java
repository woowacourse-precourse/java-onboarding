package onboarding;

import java.util.Collections;
import java.util.List;

/*
    기능 목록
    1. TreeMap 을 통해서 정렬된 key : value 값으로 세팅한다.
    2. 정렬이 총 두번 필요하므로, 1차 이름별 정렬 -> TreeMap, 2차 점수별 정렬 -> sort
    3. map -> value
        -> 본인은 카운트에서 제외
        -> 사용자와 함께 아는 친구가 있다면 점수 10점 추가
        -> 사용자의 타임 라인 방문한 횟수 1점
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
