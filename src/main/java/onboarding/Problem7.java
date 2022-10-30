package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static HashMap<String, String> friendsOfUser = new HashMap<>();
    static HashMap<String, Integer> scoreOfUser = new HashMap<>();

    public static String[] getFriends(String user) {
        String friendString = friendsOfUser.get(user);

        return friendString.split("/");
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            friendsOfUser.put(user1, friendsOfUser.getOrDefault(user1, "") + user2 + "/");
            friendsOfUser.put(user2, friendsOfUser.getOrDefault(user2, "") + user1 + "/");
        }

        String[] friendArr = getFriends(user);
        for (String friend : friendArr) {
            String[] friendOfFriendArr = getFriends(friend);
            for (String friendOfFriend : friendOfFriendArr) {
                scoreOfUser.put(friendOfFriend, scoreOfUser.getOrDefault(friendOfFriend, 0) + 10);
            }
        }

        System.out.println(scoreOfUser);

        return List.of("Test");
    }
}
