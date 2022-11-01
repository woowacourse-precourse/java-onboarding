package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    // 친구별 방문 수 반환
    private static Map<String, Integer> getVisitScore(List<String> visitors) {
        Map<String, Integer> visitScore = new HashMap<>();

        for (String visitor : visitors) {
            if (visitScore.containsKey(visitor))
                visitScore.put(visitor, visitScore.get(visitor) + 1);
            else
                visitScore.put(visitor, 1);
        }
        return visitScore;
    }

    // 친구별 함께 아는 친구의 수 -> 점수 반환 (1 이상인 친구만)
    private static Map<String, Integer> getFOFScore(String user, List<List<String>> friends, Set<String> neighbor) {
        Map<String, Integer> fof = new HashMap<>();

        int index;
        for (List<String> relation : friends) {
            if ((index = getIndexOfFOF(user, relation, neighbor)) != -1) {
                String f = relation.get(index);

                if (fof.containsKey(f))
                    fof.put(f, fof.get(f) + 10);
                else
                    fof.put(f, 10);
            }
        }

        return fof;
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
