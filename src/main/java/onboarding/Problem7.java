package onboarding;

import java.util.*;

public class Problem7 {

    private static List<String> alreadyFriend;
    private static HashMap<String, Integer> scoreMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        init(user);
        putFriendsToMap(user, friends);
    }

    private static void init(String user) {
        alreadyFriend = new ArrayList<>();
        scoreMap = new HashMap<>();
        scoreMap.put(user, 0);
    }

    private static void putFriendsToMap(String user, List<List<String>> friends) {
        for (List<String> list : friends) {
            if (list.get(0).equals(user)) {
                alreadyFriend.add(list.get(1));
                scoreMap.put(list.get(1), 0);
            } else if (list.get(1).equals(user)) {
                alreadyFriend.add(list.get(0));
                scoreMap.put(list.get(0), 0);
            } else {
                if(!scoreMap.containsKey(list.get(0))) scoreMap.put(list.get(0), 0);
                if(!scoreMap.containsKey(list.get(1))) scoreMap.put(list.get(1), 0);
            }
        }
    }

}
