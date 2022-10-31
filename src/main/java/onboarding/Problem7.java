package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 친구 관계를 인접 리스트로 나타내기
 * 2. 사용자와 함께 아는 친구에게 10점씩 주기
 * 3. 방문한 친구에게 1점씩 주기
 * 4. 사용자, 사용자가 아는 사람들은 결과에 영향을 안끼치도록 점수 없애기
 * 5. 점수와 이름으로 정렬하기
 * 6. 최대 5명의 이름 반환하기
 */
public class Problem7 {
    static Map<String, List<String>> makeRelation(List<List<String>> friends) {
        Map<String, List<String>> relation = new HashMap<>();

        for (List<String> friend: friends) {
            String p0 = friend.get(0), p1 = friend.get(1);

            List<String> l0 = new ArrayList<>();
            if (relation.containsKey(p0)) {
                l0 = relation.get(p0);
            }
            l0.add(p1);
            relation.put(friend.get(0), l0);

            List<String> l1 = new ArrayList<>();
            if (relation.containsKey(p1)) {
                l1 = relation.get(p1);
            }
            l1.add(p0);
            relation.put(friend.get(1), l1);
        }
        return relation;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
