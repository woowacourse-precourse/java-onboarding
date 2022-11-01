package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    // 사용자와 직접 친구인 neighbor 찾기
    private static Set<String> getNeighbor(String user, List<List<String>> friends) {
        Set<String> neighbor = new HashSet<>();

        // 사용자와 직접 친구인 neighbor 찾기
        for (List<String> relation : friends) {
            String u1 = relation.get(0);
            String u2 = relation.get(1);

            if (u1.equals(user))
                neighbor.add(u2);
            else if (u2.equals(user))
                neighbor.add(u1);
        }
        return neighbor;
    }
}
