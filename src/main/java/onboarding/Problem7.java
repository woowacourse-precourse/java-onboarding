package onboarding;

import java.util.Collections;
import java.util.List;

/*기능 요구 사항*/
/* 추천 알고리즘
 * 1. 사용자와 함께 아는 친구의 수 = 10점
 * 2. 사용자의 타임라인에 방문한 횟수
 * 3. 친구 추천 규칙에 따라 점수가 높은 순으로 최대 5명 return
 * 4. 이미 친구인 사람은 추천 X
 <solution>
 *  - 친구 관계 정보를 사용자의 친구로 나타내기 위해 해쉬맵을 이용한다.
 *  - 해쉬맵에 친구 정보를 모두 저장한다.
 *  - user를 통해 사용자의 친구 목록을 저장한다.
 *  - 이용자들의 친구 목록을 조회해 user와 겹치는 경우 친구의 수만큼 +10을 해준다.
 *  - visitors의 정보를 이용해 +1을 해준다.
 *  - 이미 친구의 경우를 제외하여, 최대 5명을 return 한다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
