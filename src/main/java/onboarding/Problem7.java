package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
1. 친구목록 생성하기
2. 지인 확인하기
3. 지인, 방믄자 점수 계산하기
4. 추천 점수 내림차순 정렬하기 (같으면 이름 오름차순 정렬)
*/

public class Problem7 {

    private static Map<String, Integer> calculateScores(Map<String, Integer> mutualFriendsMap, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();

        for (String friend : mutualFriendsMap.keySet()) {
            scoreMap.put(friend, mutualFriendsMap.get(friend) * 10);
        }
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }
        return scoreMap;
    }

    private static Map<String, Integer> getMutualFriends(String user, List<List<String>> friends, Set<String> userFriends) {
        Map<String, Integer> mutualFriendMap = new HashMap<>();
        for (List<String> relationship : friends) {
            String name1 = relationship.get(0);
            String name2 = relationship.get(1);
            if (name1.equals(user) || name2.equals(user)) {
                continue;
            }
            if (userFriends.contains(name1)) {
                mutualFriendMap.put(name2, mutualFriendMap.getOrDefault(name2, 0) + 1);
            }
            if (userFriends.contains(name2)) {
                mutualFriendMap.put(name1, mutualFriendMap.getOrDefault(name1, 0) + 1);
            }
        }
        return mutualFriendMap;
    }

    private static Set<String> getUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriends = new HashSet<>();
        for (List<String> relationship : friends) {
            String name1 = relationship.get(0);
            String name2 = relationship.get(1);
            if (name1.equals(user)) {
                userFriends.add(name2);
            }
            if (name2.equals(user)) {
                userFriends.add(name1);
            }
        }
        return userFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = getUserFriends(user, friends);
        Map<String, Integer> mutualFriends = getMutualFriends(user, friends, userFriends);
        Map<String, Integer> scores = calculateScores(mutualFriends, visitors);
        List<String> answer = scores.entrySet()
                .stream()
                .filter(entry -> !userFriends.contains(entry.getKey()))
                .sorted((entry1, entry2) -> {
                    if (entry1.getValue().equals(entry2.getValue())) {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return entry2.getValue().compareTo(entry1.getValue());
                })
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return answer;
    }
}
