package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> friendSetMap = mapFriendSet(friends);
        HashMap<String, Integer> scoreMap = new HashMap<>();

        mapScoreByCommonFriend(user, friendSetMap, scoreMap);
        mapScoreByVisit(visitors, scoreMap);

        List<String> answer = Collections.emptyList();

        return answer;
    }

    private static HashMap<String, HashSet<String>> mapFriendSet(List<List<String>> friends) {
        HashMap<String, HashSet<String>> ret = new HashMap<>();
        for (List<String> list : friends) {

            ret.putIfAbsent(list.get(0), new HashSet<>());
            ret.putIfAbsent(list.get(1), new HashSet<>());

            ret.get(list.get(0)).add(list.get(1));
            ret.get(list.get(1)).add(list.get(0));
        }

        return ret;
    }

    private static void mapScoreByCommonFriend(String user, HashMap<String, HashSet<String>> friendSetMap,
                                              HashMap<String, Integer> scoreMap) {

        if (!friendSetMap.containsKey(user)) {
            return;
        }

        HashSet<String> userFriendSet = friendSetMap.get(user);

        for (String userFriend : userFriendSet) {
            HashSet<String> friendFriendSet = friendSetMap.get(userFriend);

            for (String friendFriend : friendFriendSet) {
                int score = scoreMap.getOrDefault(friendFriend, 0);
                scoreMap.put(friendFriend, score + 10);
            }
        }

    }

    private static void mapScoreByVisit(List<String> visitors, HashMap<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            int score = scoreMap.getOrDefault(visitor, 0);
            scoreMap.put(visitor, score + 1);
        }
    }

}
