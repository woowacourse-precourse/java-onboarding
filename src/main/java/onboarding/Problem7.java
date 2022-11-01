package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /*
     * 친구 관계 정보를 받아, 친구 관계를 나타내는 Map 반환
     */
    public static Map<String, List<String>> generateFriendRelInfo(
            List<List<String>> friends) {
        Map<String, List<String>> friendRelInfo = new HashMap<>();

        for (List<String> friend : friends) {
            String friendFirstName = friend.get(0);
            String friendSecondName = friend.get(1);

            if (friendRelInfo.containsKey(friendFirstName)) {
                friendRelInfo.get(friendFirstName).add(friendSecondName);
            } else if (!friendRelInfo.containsKey(friendFirstName)) {
                List<String> friendRelList = new ArrayList<>();
                friendRelList.add(friendSecondName);
                friendRelInfo.put(friendFirstName, friendRelList);
            }

            if (friendRelInfo.containsKey(friendSecondName)) {
                friendRelInfo.get(friendSecondName).add(friendFirstName);

            } else if (!friendRelInfo.containsKey(friendSecondName)) {
                List<String> friendRelList = new ArrayList<>();
                friendRelList.add(friendFirstName);
                friendRelInfo.put(friendSecondName, friendRelList);
            }
        }

        return friendRelInfo;
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
