package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
* 기능 목록
* 1. 친구 관계 저장
* 2. 함께 아는 친구 점수 계산
* 3. 타임라인에 방문한 횟수 점수 계산
* 4. 점수가 높은 5명 구하기
* */
public class Problem7 {

    public static Map<String, List<String>> friendMap;
    public static Map<String, Integer> scoreMap;

    // 친구 관계 저장
    public static void addFriend(String friend1, String friend2) {
        if (friendMap.containsKey(friend1)) {
            friendMap.get(friend1).add(friend2);
        } else {
            friendMap.put(friend1, new ArrayList<>(List.of(friend2)));
        }
        if (friendMap.containsKey(friend2)) {
            friendMap.get(friend2).add(friend1);
        } else {
            friendMap.put(friend2, new ArrayList<>(List.of(friend1)));
        }
    }

    // 함께 아는 친구 점수 계산
    public static void getScoreFromSameFriend(String user) {
        List<String> myFriends = new ArrayList<>();
        if (friendMap.containsKey(user)) {
            myFriends = friendMap.get(user);
        }
        for (String friend : friendMap.keySet()) {
            // 이미 친구인 경우 추천하지 않음
            if (myFriends.contains(friend)) continue;
            // 자신인 경우
            if (user.equals(friend)) continue;

            int score = 0;
            for (String person : friendMap.get(friend)) {
                if (myFriends.contains(person)) {
                    score += 10;
                }
            }
            scoreMap.put(friend, score);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
