package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Set<String>> relationshipMap = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String s1 = friend.get(0);
            String s2 = friend.get(1);
            relationshipMap.putIfAbsent(s1, new HashSet<>());
            relationshipMap.get(s1).add(s2);
            relationshipMap.putIfAbsent(s2, new HashSet<>());
            relationshipMap.get(s2).add(s1);
        }

        if (relationshipMap.containsKey(user)) {
            userFriends = new ArrayList<>(relationshipMap.get(user));
        }

        for (String userFriend : userFriends) {
            List<String> recommendList = new ArrayList<>(relationshipMap.get(userFriend));

            for (String s : recommendList) {
                if (!s.equals(user) && !userFriends.contains(s)) {
                    scoreMap.put(s, scoreMap.getOrDefault(s, 0) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
            }
        }

        List<String> resultNameList = new ArrayList<>(scoreMap.keySet());

        resultNameList.sort((e1, e2) -> {
            if (scoreMap.get(e1).equals(scoreMap.get(e2))) {
                return e1.compareTo(e2);
            }
            return scoreMap.get(e2).compareTo(scoreMap.get(e1));
        });

        return resultNameList.subList(0, Math.min(resultNameList.size(), 5));
    }
}
