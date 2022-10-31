package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, ArrayList<String>> friendList = new HashMap<>();
        convertFriendList(friends, friendList);

        return answer;
    }

    private static void convertFriendList(List<List<String>> friends, Map<String, ArrayList<String>> friendList) {
        for (List<String> friend : friends) {
            friendList.put(friend.get(0), new ArrayList<>());
            friendList.put(friend.get(1), new ArrayList<>());
        }
        for (List<String> friend : friends) {
            friendList.get(friend.get(0)).add(friend.get(1));
            friendList.get(friend.get(1)).add(friend.get(0));
        }
    }
}
