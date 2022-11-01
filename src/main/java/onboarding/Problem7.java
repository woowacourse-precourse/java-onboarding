package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /*
     * 1. 친구 관계 정보를 받아, 친구 관계를 나타내는 Map 생성
     * 2. 리스트를 탐색하면서, 사용자가 존재하는 경우
     * 2. 사용자와 함께 아는 친구를 계산
     *      2-1. 친구 리스트를 받아,
     * 3. 사용자의 타임라인에 방문한 횟수 계산
     */

    /*
     * 친구 관계 정보를 받아, 친구 관계를 나타내는 Map 반환
     */
    public static Map<String, List<String>> generateFriendRelInfo(
            String user, List<List<String>> friends) {

        return Collections.emptyMap();
    }

    /*
     * 친구 추천 규칙 중, 사용자와 함께 아는 친구의 경우를 계산한 Map 반환
     */
    public static Map<String, Integer> calScoreOfFriendRelWithUser(
            String user, List<List<String>> friends) {

        return Collections.emptyMap();
    }

    /*
     * 친구 추천 규칙 중, 사용자에 타임라인에 방문한 횟수를 계산한 Map 반환
     */
    public static Map<String, Integer> calNumOfVisitToTimeline(
            Map<String, Integer> scoreInfo, List<String> visitors) {

        return Collections.emptyMap();
    }

    /*
     * 친구 추천 규칙에 따라 만들어진 점수 중, 가장 높은 순으로 정렬한 5명을 반환
     */
    public static List<String> calTopFiveOfScoreInfo(
            Map<String, Integer> scoreInfo) {

        return Collections.emptyList();
    }


}
