package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static HashMap<String, List<String>> friendMap;
    static HashMap<String, Integer> scoreCountMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init();
        makeFriendsMap(friends);
        findAcquaintance(user);


        List<String> answer = Collections.emptyList();


        return answer;
    }

    private static void findAcquaintance(String user) {
        List<String> friends = friendMap.get(user);
        for (String friend : friends) {
            List<String> friendsOfFriends = friendMap.get(friend);
            for (String friendOfFriend : friendsOfFriends) {
                if (friendOfFriend.equals(user)) {
                    continue;
                }
                scoreCountMap.put(friendOfFriend, scoreCountMap.get(friendOfFriend) + 1);
            }
        }
    }

    private static void init(){
        friendMap = new HashMap<>();
        scoreCountMap = new HashMap<>();
    }
    private static void makeFriendsMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            if (friendMap.containsKey(user1)) {
                friendMap.get(user1).add(user2);
            } else {
                scoreCountMap.put(user1, 0);
                List<String> list = new ArrayList<>();
                list.add(user2);
                friendMap.put(user1, list);
            }

            if (friendMap.containsKey(user2)) {
                friendMap.get(user2).add(user1);
            } else {
                scoreCountMap.put(user2, 0);
                List<String> list = new ArrayList<>();
                list.add(user1);
                friendMap.put(user2, list);
            }
        }
    }
}
