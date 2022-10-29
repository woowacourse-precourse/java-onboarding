package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return
 *      - 사용자와 함께 아는 친구의 수 = 10점
 *      - 사용자의 타임 라인에 방문한 횟수 = 1점
 *
 * 1. 접근 방식
 *  - 사용자와 친구간 그래프를 만들어 사용자를 기준으로 BFS 탐색 2depth 실행
 *      - 1 depth : 사용자의 친구들
 *      - 2 depth : 사용자와 동일한 친구를 아는 사람들
 *  - visitor는 최종적으로 더함
 *
 * */
public class Problem7 {

    private LinkedList<String> friendGraph = new LinkedList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    
}
