package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<String>();
        Map<String, List<String>> friendMap = getFriendsMap(friends);
        return answer;
    }

    static Map<String, List<String>> getFriendsMap(List<List<String>> friends) {
        Map<String, List<String>> friendsMap = new HashMap<String, List<String>>();
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            friendsMap = addFriends(friendsMap, friendA, friendB);
            friendsMap = addFriends(friendsMap, friendB, friendA)
        }
        return friendsMap;
    }
}
