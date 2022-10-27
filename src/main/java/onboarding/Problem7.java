package onboarding;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userAndFriendList = getFriendList(friends, user);
        userAndFriendList.add(user);

        return answer;
    }


    private static List <String> getFriendList(List<List<String>> friends, String user) {
        List<String> friendList = new ArrayList<>();
        for (List<String> friendRelation : friends) {
            String friend = "";
            if (isFriendWithUser(friendRelation, user)) {
                friend = getFriend(friendRelation, user);
                friendList.add(friend);
            }
        }
        return friendList;
    }

    private static String getFriend(List<String> friendRelation, String user) {
        if (friendRelation.get(0).equals(user)) {
            return friendRelation.get(1);
        }
        return friendRelation.get(0);
    }

    private static boolean isFriendWithUser(List<String> friendRelation, String user) {
        return friendRelation.contains(user);
    }
}
