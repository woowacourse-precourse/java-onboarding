package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    static List<String> userFriends = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        for (int i = 0; i < friends.size(); i++) {
            List<String> friendsList = friends.get(i);
            findUserFriend(friendsList, user);
        }
        System.out.println(userFriends);


        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void findUserFriend(List<String> friendsList, String user) {
        if (friendsList.contains(user) && friendsList.indexOf(user) == 0) {
            userFriends.add(friendsList.get(1));
        }

        if (friendsList.contains(user) && friendsList.indexOf(user) == 1) {
            userFriends.add(friendsList.get(0));
        }
    }
}
