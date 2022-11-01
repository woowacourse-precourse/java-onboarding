package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
//    규칙 너무 길어서 제한사항, 요약만 기입.
//
//    제한사항
//    1. user는 길이가 1 이상 30 이하인 문자열이다.
//    2. friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
//    3. friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
//    4. A와 B는 친구라는 의미이다.
//    5. 아이디는 길이가 1 이상 30 이하인 문자열이다.
//    6. visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
//    7. 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
//    8. 동일한 친구 관계가 중복해서 주어지지 않는다.
//    9. 추천할 친구가 없는 경우는 주어지지 않는다.

    //    -- 요약 --
//    1. 방문자 점수가 가장 높은 순으로 최대 5명 return.
//      1-1 추천 점수 0점은 추천하지 않는다.
//      1-2 점수가 같으면 이름순으로 정렬한다.
//    2. 점수
//      2-1 사용자와 함께 아는 친구의 수 = 10점
//      2-2 사용자의 타임 라인에 방문한 횟수 = 1점
//
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//      1. 우선 user를 받아오자.
//      2. user 정보를 해석하고 계산하는 메서드 구현
//      3. 점수 높은순으로 정렬 메서드 구현
//        3-1 같은 점수 이름순 정렬
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
