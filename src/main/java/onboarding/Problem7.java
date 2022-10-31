package onboarding;

import java.util.*;

public class Problem7 {

    private static List<String> alreadyFriend;
    private static HashMap<String, Integer> scoreMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        init(user);
    }

    private static void init(String user) {
        alreadyFriend = new ArrayList<>();
        scoreMap = new HashMap<>();
        scoreMap.put(user, 0);
    }

}
