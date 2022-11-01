package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> usersFriends = getUsersFriends(user, friends);

        return answer;
    }

    private static List<String> getUsersFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> name : friends) {
            if (name.get(0).equals(user)) {
                friendList.add(name.get(1));
            }
            if (name.get(1).equals(user)) {
                friendList.add(name.get(0));
            }
        }
        return friendList;
    }
}
