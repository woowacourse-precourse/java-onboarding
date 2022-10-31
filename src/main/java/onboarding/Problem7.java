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

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
