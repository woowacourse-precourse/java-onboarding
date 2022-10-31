package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    private static void calVisitorScore(String user, List<String> visitors, Map<String, List<String>> friendsMap,
        Map<String, Integer> scoreMap) {
        visitors.stream().filter(visitor -> !friendsMap.get(user).contains(visitor))
            .forEach(visitor -> scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1));
    }

    private static void calFriendScore(String user, Map<String, List<String>> friendsMap, Map<String, Integer> scoreMap) {
        for (String name : friendsMap.get(user)) {
            for (String recommend : friendsMap.get(name)) {
                if (!friendsMap.get(user).contains(recommend) && !recommend.equals(user)) {
                    scoreMap.put(recommend, scoreMap.getOrDefault(recommend, 0) + 10);
                }
            }
        }
    }

    private static Map<String, List<String>> makeFriendMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendList = new HashMap<>();
        friends.forEach(friend -> {
            friendList.computeIfAbsent(friend.get(0), e -> new ArrayList<>()).add(friend.get(1));
            friendList.computeIfAbsent(friend.get(1), e -> new ArrayList<>()).add(friend.get(0));
        });
        return friendList;
    }
}
