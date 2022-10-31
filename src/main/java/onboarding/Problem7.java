package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (!map.keySet().contains(friend1)) map.put(friend1, new ArrayList<>());
            if (!map.keySet().contains(friend2)) map.put(friend2, new ArrayList<>());

            map.get(friend1).add(friend2);
            map.get(friend2).add(friend1);
        }

        // 타임라인 방문횟수 반영: 각 1점
        for (String visitor : visitors) {
            // 이미 친구인 사람은 추천할 필요가 없기에 제외
            if (isFriend(map, user, visitor)) continue;
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }

        return answer;
    }

    // 이름이 name인 사람의 친구중 friend가 있는가
    private static boolean isFriend(Map<String, List<String>> map, String name, String friend) {
        return map.get(name).contains(friend);
    }
}
