package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendsMap = makeFriendsMap(user, friends);
        Map<String, Integer> scores = new HashMap<>();
        togetherFollowScoreProcess(user, friendsMap, scores);
        visitScoreProcess(user, friendsMap, visitors, scores);
        return makeResult(scores);
    }

    // key: 이름, value: 친구 Set을 가진 Map을 만드는 메서드
    private static Map<String, Set<String>> makeFriendsMap(String user, List<List<String>> friends) {
        Map<String, Set<String>> friendsMap = new HashMap<>();

        friends.stream().forEach((l) -> {
            if(!friendsMap.containsKey(l.get(0)))   friendsMap.put(l.get(0), new HashSet<>());
            friendsMap.get(l.get(0)).add(l.get(1));
            if(!friendsMap.containsKey(l.get(1)))   friendsMap.put(l.get(1), new HashSet<>());
            friendsMap.get(l.get(1)).add(l.get(0));
        });

        return friendsMap;
    }

    // 함께 아는 친구 점수를 매기는 메서드
    private static void togetherFollowScoreProcess(String user, Map<String, Set<String>> friendsMap, Map<String, Integer> scores) {
        for(String friendName : friendsMap.keySet()) {
            if (friendName.equals(user))  continue;
            int followTogetherCount = followTogetherCount(user, friendsMap, friendName);
            if (followTogetherCount != 0) scores.put(friendName, followTogetherCount * 10);
        }
    }

    // 교집합을 이용한 함께 아는 친구 점수를 구하는 메서드
    private static int followTogetherCount(String user, Map<String, Set<String>> friendsMap, String friendName) {
        Set<String> friendsSetIntersection = new HashSet<>(friendsMap.get(user));
        friendsSetIntersection.retainAll(friendsMap.get(friendName));
        return friendsSetIntersection.size();
    }

    // 방문자 수 점수를 매기는 메서드
    private static void visitScoreProcess(String user, Map<String, Set<String>> friendsMap, List<String> visitors, Map<String, Integer> scores) {
        visitors.forEach(visitor -> {
            if(!user.equals(visitor) && !friendsMap.get(user).contains(visitor))
                scores.put(visitor, scores.containsKey(visitor) ? scores.get(visitor) + 1 : 1);
        });
    }

    private static List<String> makeResult(Map<String, Integer> scores) {
        return new ArrayList<>(scores.keySet()).stream().sorted((a, b) -> !scores.get(a).equals(scores.get(b)) ? scores.get(b).compareTo(scores.get(a)) : a.compareTo(b)).limit(5).collect(Collectors.toList());
    }
}
