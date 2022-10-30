package onboarding;

import java.util.*;

public class Problem7 {
    /*
        기능 요구 사항 목록
        1. 사용자의 친구 리스트 반환 함수
        2. 친구의 친구 점수 해시맵 반환 함수
        3. 방문자 점수 해시맵 반환 함수
        4. 해시맵 정렬 함수
        5. solution (함수 순서대로 실행)
    */

    // 주어진 사용자의 친구 리스트 반환 함수
    private static List<String> userFriend(String user, List<List<String>> friendDb, HashSet<String> users) {
        List<String> friends = new ArrayList<>(List.of());

        for (List<String> relationship : friendDb) {
            if (relationship.contains(user)) {
                int userIndex = relationship.indexOf(user); // 사용자의 인덱스
                int friendIndex = 1 - userIndex;            // 사용자 친구의 인덱스
                String userFriend = relationship.get(friendIndex);
                friends.add(userFriend);
            }
        }
        return friends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
