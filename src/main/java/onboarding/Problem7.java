package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {

    private static final int FRIEND_A = 0;
    private static final int FRIEND_B = 1;

    private static List<String> userFriends = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userFriends.clear();

        reflectAlreadyUserFriends(user, friends);
    }

    private static void reflectAlreadyUserFriends(String user, List<List<String>> friends) {
        friends.forEach(friend -> addUserFriend(user, friend.get(FRIEND_A), friend.get(FRIEND_B)));
    }

    private static void addUserFriend(String userName, String friendAName, String friendBName) {
        if (friendAName.equals(userName)) {
            userFriends.add(friendBName);
        }
        if (friendBName.equals(userName)) {
            userFriends.add(friendAName);
        }
    }

}
