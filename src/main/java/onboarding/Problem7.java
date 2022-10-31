package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    // 사용자와 이미 친구인 리스트 반환해주는 함수
    private static List<String> findDirectFriend(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();

        for (List<String> relation: friends) {
            if (relation.get(0) == user) list.add(relation.get(1));
            if (relation.get(1) == user) list.add(relation.get(0));
        }

        return list;
    }

    // 사용자와 함께 아는 친구에게 +10 해주는 함수
    private static void scoreMutualFriend(String user, List<List<String>> friends, List<String> directFriends, Map<String, Integer> map) {
        for (String directFriend: directFriends) {
            for (List<String> friend : friends) {
                if (friend.get(0) == directFriend) { // 0번째 인덱스 확인
                    map.put(friend.get(1), map.getOrDefault(friend.get(1), 0) + 10);
                } else if (friend.get(1) == directFriend) { // 1번째 인덱스 확인
                    map.put(friend.get(0), map.getOrDefault(friend.get(0), 0) + 10);
                }
            }
        }

        // 이때, 사용자를 포함하고 있으면 제거해준다.
        if (map.containsKey(user)) map.remove(user);
    }

    // 사용자의 타임 라인에 방문한 친구에게 +1 해주는 함수
    private static void scoreVisitors(List<String> visitors, Map<String, Integer> map) {
        for (String visitor: visitors) {
            map.put(visitor, map.getOrDefault(visitor, 0) + 1);
        }
    }

    // 이미 친구인 목록 제거하는 함수
    private static void removeDirectFriend(String user, List<String> directFriends, Map<String, Integer> map) {
        for (String directFriend : directFriends) {
            if (map.containsKey(directFriend)) {
                map.remove(directFriend);
            }
        }
    }

    // 정렬 후 최대 5개까지만 반환하는 함수
    private static List<String> selectFiveFriends(Map<String, Integer> map) {
        List<String> list = new ArrayList<>();

        // 정렬
        List<Map.Entry<String, Integer>> sortMap = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());

        // 최대 5개까지 list에 추가하도록
        for (Map.Entry<String, Integer> item: sortMap) {
            if (list.size() > 5) break;
            list.add(item.getKey());
        }

        return list;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = new HashMap<>();
        List<String> directFriends = findDirectFriend(user, friends);

        scoreMutualFriend(user, friends, directFriends, map);
        scoreVisitors(visitors, map);
        removeDirectFriend(user, directFriends, map);

        return selectFiveFriends(map);
    }
}