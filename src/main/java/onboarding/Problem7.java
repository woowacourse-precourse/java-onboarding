package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {


    private static HashMap<String, HashSet<String>> friendMap = new HashMap<>();
    private static HashMap<String, Integer> scoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }

    private static void setFriendMap(List<List<String>> friends) {
        String userA, userB;
        for (int i = 0; i < friends.size(); i++) {
            userA = friends.get(i).get(0);
            userB = friends.get(i).get(1);
            mappingFriend(userA, userB);
            mappingFriend(userA, userB);
        }
    }

    private static void mappingFriend(String userA, String userB) {
        if (friendMap.containsKey(userA)) {
            friendMap.get(userA).add(userB);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(userB);
            friendMap.put(userA, set);
        }
    }

}
