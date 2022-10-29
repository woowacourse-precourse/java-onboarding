/*
[기능 목록]

1. 친구 관계 클래스
    1) 프로퍼티
        - 친구 관계를 저장하는 자료구조
    2) 메서드
        - 친구 관계 추가
        - 공동 친구 수 구하기

2. 친밀도 클래스
    1) 프로퍼티
        - 친밀도 계산의 목표가 되는 user id
        - id
        - 공동 친구 수
        - 방문 횟수
    2) 메서드
        - 공동 친구 수 getter / setter
        - 방문 횟수 getter / setter
        - 점수 구하기
        - 정렬을 위한 compareTo

3. 추천 클래스
    1) 프로퍼티
        - user id
        - 친구가 아닌 사용자와의 친밀도 Set
            -> 특징 : 친밀도 순으로 정렬

    2) 메서드
        - 다른 사용자와의 친밀도 추가
        - 최대 5명의 친구 추천


4. 친구 관계 클래스 생성
5. user별 방문 횟수 카운트
6. user의 추천 클래스 생성
 */

package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
