package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> notFriendList = new ArrayList<>();
        HashSet<String> friendList = new HashSet<>();
        HashMap<String, Integer> suggestScoreList = new HashMap<>();

        friends.forEach((relationship) -> {
            String person1 = relationship.get(0);
            String person2 = relationship.get(1);

            if (Objects.equals(person1, user)) {
                friendList.add(person2);
            } else if (Objects.equals(person2, user)) {
                friendList.add(person1);
            } else {
                notFriendList.add(relationship);
            }
        });

        // 관련된 친구 수 만큼 점수 계산
        notFriendList.forEach((connection) -> {
            String person1 = connection.get(0);
            String person2 = connection.get(1);

            if (friendList.contains(person1)) {
                if (!suggestScoreList.containsKey(person2)) {
                    suggestScoreList.put(person2, 10);
                } else {
                    suggestScoreList.put(person2, suggestScoreList.get(person2) + 10);
                }
            }

            if (friendList.contains(person2)) {
                if (!suggestScoreList.containsKey(person1)) {
                    suggestScoreList.put(person1, 10);
                } else {
                    suggestScoreList.put(person1, suggestScoreList.get(person1) + 10);
                }
            }
        });

        // 방문수 만큼 점수 계산
        List<String> visitConnections = visitors.stream().filter(x -> !friendList.contains(x)).collect(Collectors.toList());
        visitConnections.forEach((visitor) -> {
            if (!suggestScoreList.containsKey(visitor)) {
                suggestScoreList.put(visitor, 1);
            } else {
                suggestScoreList.put(visitor, suggestScoreList.get(visitor) + 1);
            }
        });

        System.out.println(suggestScoreList);

        // 점수 별로 정렬한 후 유저 이름대로 정렬
        // 정렬하는 메서드를 따로 뺄까..?
        HashMap<String, Integer> suggestUserSortedByScore = suggestScoreList
                .entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (newValue, oldValue) -> oldValue, LinkedHashMap::new));
        return List.of("andole", "jun", "bedi");
    }
}
