package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 1. user의 친구, 친구가 아닌 사용자를 분리한다.
        // 2. 친구가 아닌 사용자 (key) - 시작점수:0 (value) map 생성
        // 2. 친구가 아닌 사용자 중 함께 아는 친구가 있는 경우 : +(함께 아는 친구 수*10)점
        // 3. 친구가 아닌 사용자 중 방문한 사용자 : +1점
        // 4. 친구가 아닌 사용자와 점수를 매핑시킨다.
        // 5. 점수가 같은 경우, 이름 오름차순으로 정렬 & 점수가 다른 경우, 점수가 높은 순으로 정렬
        // 6. answer에 담은 후 반환
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
