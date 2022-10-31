package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * 문제 분석
 * 1. 친구 추천 알고리즘의 우선순위 부여 조건을 제시해 주고있는 문제로 보인다.
 *      즉, 정렬을 사용하고 이를 위한 클래스를 정의해야한다.
 *          class Users
 *              1. 이름 (String)
 *              2. 점수 (Integer)
 *              3. 친구들 (List<Users>)
 *          conpareto 조건
 *              - 점수순 정렬
 *              - 점수가 같다면 이름순 정렬
 * 2. 친구 관계를 설졍 한후 점수를 부여해야한다.
 *          1. 친구 관계 설정
 *                  -> 양방향으로 A.친구들 ,B.친구들 각각의 리스트에 넣어줘야한다.
 *          2. 점수 설정
 *                  1. 함께 아는 친구의 수 에 대한 점수 카운트
 *                  2. 타임라인 방문 횟수 카운트
 *                  3. 단, 이미 친구인 유저는 점수를 카운트 하지 않는다.
 *
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
