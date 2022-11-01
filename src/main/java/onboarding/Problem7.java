package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem7 {
    private static HashMap<String, List<String>> createFriendMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendMap = new HashMap<>();
        List<String> friendList;

        for (List<String> friend : friends) {
            friendList = new ArrayList<>();
            if (friendMap.containsKey(friend.get(0))) {
                friendList = friendMap.get(friend.get(0));
                friendList.add(friend.get(1));
            } else {
                friendList.add(friend.get(1));
            }
            friendMap.put(friend.get(0), friendList);

            friendList = new ArrayList<>();
            if (friendMap.containsKey(friend.get(1))) {
                friendList = friendMap.get(friend.get(1));
                friendList.add(friend.get(0));
            } else {
                friendList.add(friend.get(0));
            }
            friendMap.put(friend.get(1), friendList);
        }

        return friendMap;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendMap;
        HashMap<String, Integer> scoreMap;

        friendMap = createFriendMap(friends);

        return answer;
    }
}
