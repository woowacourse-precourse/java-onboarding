package onboarding;

import java.util.*;

public class Problem7 {

    private static List<String> alreadyFriend;
    private static HashMap<String, Integer> scoreMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        init(user);
        putFriendsToMap(user, friends);
        give10ScoreForFriendOfFriend(friends);
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

    private static void give10ScoreForFriendOfFriend(List<List<String>> friends) {
        for (List<String> list : friends) {
            if (alreadyFriend.contains(list.get(0))) {
                int score = scoreMap.get(list.get(1)) + 10;
                scoreMap.put(list.get(1), score);
            } else if (alreadyFriend.contains(list.get(1))) {
                int score = scoreMap.get(list.get(0)) + 10;
                scoreMap.put(list.get(0), score);
            }
        }
    }

}
