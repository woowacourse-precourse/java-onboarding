package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // List<List<name, score>> scores 생성
        // user와 친구 List 생성 userFriend
        // scoreCoFriend : friends를 순회하며 userFriend와 함께 아는 친구에 대해 score 10점 추가
        // scoreVisitor : visitors를 순회하며 방문자의 score 1점씩 추가
        // scores를 점수 내림차순, 이름 오름차순으로 정렬
        // 상위 5명 선택
        // score가 0인 사람 제외
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
