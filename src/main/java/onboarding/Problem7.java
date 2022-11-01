package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        Map<String, List<String>> friendsMap = getFriendsMap(friends);
        Map<String, Integer> scoreMap = getScoreMap(friendsMap, user);

        return answer;
    }

    static Map<String, List<String>> getFriendsMap(List<List<String>> friends) {
        Map<String, List<String>> friendsMap = new HashMap<String, List<String>>();
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            friendsMap = addFriend(friendsMap, friendA, friendB);
            friendsMap = addFriend(friendsMap, friendB, friendA);
        }
        return friendsMap;
    }

    static Map<String, List<String>> addFriend(Map<String, List<String>> friendsMap, String A, String B) {
        if (friendsMap.containsKey(A)) {
            friendsMap.get(A).add(B);
        } else {
            List<String> friendList = new ArrayList<String>();
            friendList.add(B);
            friendsMap.put(A, friendList);
        }
        return friendsMap;
    }

    static Map<String, Integer> getScoreMap(Map<String, List<String>> friendsMap, String user) {
        Map<String, Integer> scoreMap = new TreeMap<String, Integer>();
        List<String> friends = friendsMap.get(user);
        for (String friend : friends) {
            for (String friendOfFriend : friendsMap.get(friend)) {
                if (!scoreMap.containsKey(friendOfFriend)) {
                    scoreMap.put(friendOfFriend, 10);
                }
            }
        }
        return scoreMap;
    }
}
