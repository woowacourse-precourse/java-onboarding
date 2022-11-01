package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        /*
        1. friendsMap 만들기
        - friendsMap: 사람들 각각의 친구 목록을 담는 변수
         */

        /*
        2. user와 함께 아는 친구 점수
        - user를 제외한 사람들 각각에 대해 user와 함께 아는 친구 점수를 구함
         */

        /*
        3. 타임 라인 방문 점수
        - user를 제외한 사람들 각각에 대해 타임 라인 방문 점수를 더해줌
         */

        /*
        4. score를 정렬한 후 3명 리턴
        - value 기준 내림차순 정렬, 값이 같으면 key 기준 오름차순 정렬
         */

        return answer;
    }
}
