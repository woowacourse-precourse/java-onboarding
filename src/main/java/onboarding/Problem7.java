package onboarding;

/*

    Goal : 친구추천 알고리즘 구현하기
    Parameters: 사용자 아이디 user, 친구관계정보 friends, 사용자 타임라인 방문기록 visitors

    - 사용자와 함께 아는 친구의 수 : 10점
    - 사용자의 타임라인 방문 횟수 : 1점
    => 점수 높은 순으로 정렬하여 5명 리턴
    - 점수가 0인 경우 추천 X, 점수가 같을 경우 이름순 정렬

    To dos
    [ ] 점수 계산
    [ ] 0점 유저 제거 및 정렬
 */


import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
