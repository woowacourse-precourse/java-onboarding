package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    static ArrayList<String> makeFriendList(String user, List<List<String>> friends) {
        ArrayList<String> friendsOfUser = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                String friendName = addFriends(user, friend);
                friendsOfUser.add(friendName);
            }
        }

        return friendsOfUser;
    }

    static String addFriends(String user, List<String> friend) {
        if (friend.get(0).equals(user)) {
            return friend.get(1);
        }
        return friend.get(0);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        ArrayList<String> friendsOfUser = makeFriendList(user, friends);

        return answer;
    }
}
