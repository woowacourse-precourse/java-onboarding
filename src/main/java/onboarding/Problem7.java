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

    private static HashMap<String, Integer> scoreFriendsOfFriends(String user, HashMap<String, List<String>> friendMap) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> userFriendList = friendMap.get(user);
        List<String> friendOfFriendList;

        for (String userFriend : userFriendList) {
            friendOfFriendList = friendMap.get(userFriend);

            for (String friendOfFriend : friendOfFriendList) {
                scoreMap.put(friendOfFriend, scoreMap.getOrDefault(friendOfFriend, 0) + 10);
            }
        }

        return scoreMap;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendMap;
        HashMap<String, Integer> scoreMap;

        friendMap = createFriendMap(friends);

        scoreMap = scoreFriendsOfFriends(user, friendMap);

        return answer;
    }
}
