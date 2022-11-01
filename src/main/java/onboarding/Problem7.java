package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendMap = new HashMap<>();
        friendMapInitialize(friends, friendMap);

        Map<String, Integer> scoreMap = new HashMap<>();
        friendScoreCalculate(friendMap, user, scoreMap);
        visitorScoreCalculate(visitors, user, friendMap, scoreMap);

        List<String> answer = sortByScoreAndName(scoreMap);
        if (answer.size() > 5) {
            answer = answer.subList(0, 5);
        }

        return answer;
    }

    private static void friendMapInitialize(List<List<String>> friends, Map<String, Set<String>> friendMap) {
        for (List<String> friend:friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            friendMap.put(friend1, friendMap.getOrDefault(friend1, new HashSet<>()));
            friendMap.put(friend2, friendMap.getOrDefault(friend2, new HashSet<>()));

            Set<String> friendSet = friendMap.get(friend1);
            friendSet.add(friend2);
            friendMap.put(friend1, friendSet);

            friendSet = friendMap.get(friend2);
            friendSet.add(friend1);
            friendMap.put(friend2, friendSet);
        }
    }

    private static void friendScoreCalculate(Map<String, Set<String>> friendMap, String user,
                                             Map<String, Integer> scoreMap) {
        Set<String> userFriendSet = friendMap.get(user);
        for (String userFriend:userFriendSet) {
            Set<String> friendSet = friendMap.get(userFriend);
            for (String friend:friendSet) {
                if (!friend.equals(user))
                    scoreMap.put(friend, scoreMap.getOrDefault(friend, 0) + 10);
            }
        }
    }

    private static void visitorScoreCalculate(List<String> visitors, String user,
                                              Map<String, Set<String>> friendMap, Map<String, Integer> scoreMap) {
        for (String visitor:visitors) {
            if (!friendMap.get(user).contains(visitor))
                scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }
    }

    private static List<String> sortByScoreAndName(Map<String, Integer> scoreMap) {
        List<String> sortedList = new ArrayList<>(scoreMap.keySet());
        sortedList.sort(((o1, o2) -> scoreMap.get(o2).compareTo(scoreMap.get(o1))));

        return sortedList;
    }
}
