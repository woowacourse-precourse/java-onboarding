package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> userFriends = new ArrayList<>();
    private static Map<String, Integer> recommendDict = new HashMap<String, Integer>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

    }

    private static void findFriends(String user, List<List<String>> friends) {

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0) == user) {
                userFriends.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1) == user) {
                userFriends.add(friends.get(i).get(0));
            }
        }

    }


}