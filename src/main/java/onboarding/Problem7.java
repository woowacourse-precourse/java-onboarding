package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static Map<String, List<String>> getFriendsList(List<List<String>> friends) {
        Map<String, List<String>> friendsList = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            if (!friendsList.containsKey(friends.get(i).get(0))) {
                friendsList.put(friends.get(i).get(0), new ArrayList<>());
            }
            friendsList.get(friends.get(i).get(0)).add(friends.get(i).get(1));
            if (!friendsList.containsKey(friends.get(i).get(1))) {
                friendsList.put(friends.get(i).get(1), new ArrayList<>());
            }
            friendsList.get(friends.get(i).get(1)).add(friends.get(i).get(0));
        }
        return friendsList;
    }
}
