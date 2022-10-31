package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 구현 기능 목록
 * 1. friends를 통해 사용자의 친구 리스트 생성하여 반환
 * 2. friends와 친구 리스트를 통해 친구의 친구 리스트 생성하여 반환
 * 3. 주어진 리스트에서 사용자와 사용자의 친구는 삭제
 * 4. 친구의 친구 리스트와 방문자 리스트를 통해 추천 대상을 HashMap으로 저장
 * 5. 추천 친구 점수 계산
 * 6. 점수가 높은 순으로 정렬하여 반환
 * */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> findFriendOfUser(String user, List<List<String>> friends) {
        List<String> friendOfUser = new ArrayList<>();
        for (List<String> relation : friends) {
            if (relation.contains(user))
                friendOfUser.addAll(relation);
        }
        friendOfUser.removeAll(List.of(user));
        return friendOfUser;
    }
}
