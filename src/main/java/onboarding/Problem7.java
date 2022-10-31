package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 친구 관계 확립
        Map<String, Set<String>> friendShip = new HashMap<>();

        for (List<String> friend : friends) {
            String people1 = friend.get(0);
            if (!friendShip.containsKey(people1)) {
                friendShip.put(people1, new HashSet<>());
            }
            String people2 = friend.get(1);
            if (!friendShip.containsKey(people2)) {
                friendShip.put(people2, new HashSet<>());
            }
            friendShip.get(people1).add(people2);
            friendShip.get(people2).add(people1);
        }

        // 추천 점수 확인
        Map<String, Integer> relationScore = new LinkedHashMap<>();
        Set<String> userFriends = friendShip.get(user);

        // User 와 함께 알고 있는 친구 수 확인
        for (String otherUser : friendShip.keySet()) {
            for (String userFriend : userFriends) {
                if (friendShip.get(otherUser).contains(userFriend)) {
                    relationScore.put(otherUser, relationScore.getOrDefault(otherUser, 0) + 10);
                }
            }
        }

        // 방문한 회수 확인
        for (String visitor : visitors) {
            relationScore.put(visitor, relationScore.getOrDefault(visitor, 0) + 1);
        }

        // 친구 추천
        List<String> collect = relationScore.keySet().stream()
                .sorted((key1, key2) -> {
                    return relationScore.get(key2) - relationScore.get(key1);
                })
                .filter((key)->{
                    return !friendShip.get(user).contains(key) && !key.equals(user);
                })
                .filter((key) -> {
                    return relationScore.get(key) != 0;
                })
                .limit(5)
                .collect(Collectors.toList());

        return collect;
    }
}
