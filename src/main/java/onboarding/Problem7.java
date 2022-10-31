package onboarding;

import java.util.*;

public class Problem7 {
    /**
     * 기능 구현
     * 1. user와 이미 친구인 사람을 찾기
     * 2. user의 친구와 친구인 사람을 찾기
     * 3. 사용자와 함께 아는 친구 점수
     * 4. 사용자의 타임 라인에 방문한 횟수
     * 5. 결과값 정렬, 5개 제한
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // user와 이미 친구인 사람을 찾는 로직
        List<String> alreadyFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(1).equals(user)) {
                alreadyFriends.add(friend.get(0));
            }
        }

        return answer;
    }
}
