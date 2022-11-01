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

    // 해당 릴레이션이 친구의 친구인지 판단 및 릴레이션에서의 위치 반환 (false -> -1)
    private static int getIndexOfFOF(String user, List<String> relation, Set<String> neighbor) {
        String u1 = relation.get(0);
        String u2 = relation.get(1);

        if (neighbor.contains(u1) && !user.equals(u2))
            return 1;
        else if (neighbor.contains(u2) && !user.equals(u1))
            return 0;
        return -1;
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
