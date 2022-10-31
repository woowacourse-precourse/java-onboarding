package onboarding;

import java.util.*;
/*

[기능 목록]
1. 친구 추천 점수를 기록하기 위해 Map<> 타입의 변수를 초기화 하기
2. 현재 유저와 친구인 사람의 이름을 리스트로 반환하기
3. 내 타임라인 방문자들의 친구 추천 점수를 올리기 (단, 2번 메서드를 활용하여 이미 친구인 사람이 방문했을 경우는 점수를 올리지 않는다.)
4. 나와 함께 아는 친구를 바탕으로 추천 스코어 반영하기
5. Map 형의 친구 추천 스코어를 Value 를 기준으로 하여 정렬한 후, 리스트로 변환하기 (단, value 가 0인 Key는 변환하지 않는다.)

*/

public class Problem7 {

    // 추천 친구 스코어를 기록하기 위한 recommendScore 셋팅
    public static Map<String, Integer> initRecommendScore(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> recommendScore = new HashMap<>();

        for (List<String> friend : friends) {
            for (String name : friend) {
                if (!user.equals(name)) {
                    recommendScore.put(name, 0);
                }
            }
        }

        for (String visitor : visitors) {
            recommendScore.put(visitor, 0);
        }

        return recommendScore;
    }

    // 현재 유저의 친구인 사람 리스트로 반환하기
    public static List<String> extractWhoIsMyFriends(String user, List<List<String>> friends) {

        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    userFriends.add(friend.get(1));
                } else if (friend.get(1).equals(user)) {
                    userFriends.add(friend.get(0));
                }
            }
        }
        return userFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
