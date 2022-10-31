package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriendsList = myFriends(user, friends);
        return myFriendsList;
    }

    private static List<String> myFriends(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                list.add(friends.get(i).get(1));
            }
            if (user.equals(friends.get(i).get(1))) {
                list.add(friends.get(i).get(0));
            }
        }
        return list;
    }
}
