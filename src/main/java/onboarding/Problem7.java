package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * Problem 7
 *
 * 기능 요구 사항
 * 1. 친추 추천 알고리즘
 *     - 사용자와 함꼐 아는 친구 = 10점
 *     - 사용자의 타임라인에 방문한 횟수 = 1점
 * 2. Param
 *     - user : 사용자 아이디
 *     - friend : 친구 관계 정보
 *     - visitor : 사용자 타임라인 방문 기록
 * 3. 점수가 가장 높은 순으로 정렬하여 최대 5명을 return
 * 4. 추천 점수가 0이면 추천 X
 * 5. 점수가 같으면 이름 순
 *
 * 제한 사항
 * 1. user의 길이 : 1~30
 * 2. friends의 길이 : 1~10,000이하의 리스트
 * 3. friends각 원소 : 길이 2인 리시트, [아이디A, 아이디B] = A와 B는 친구, 1~30아히의 길이
 * 4. visitor : 0~10,000 리스트
 * 5. 알파벳 소문자로만 이루어져 있다.
 * 6. 동일한 친구관계 중복 주어지지 않는다.
 * 7. 추천할 친구가 없는 경우는 주어지지 않는다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
