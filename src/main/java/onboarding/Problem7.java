package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Integer> friendList = getTotalUser(friends);
        return answer;
    }

    public static HashMap<String, Integer> getTotalUser(List<List<String>> friends) {
        HashMap<String, Integer> userList = new HashMap<>();

        for (List<String> friend : friends) {
            userList.put(friend.get(0), 0);
            userList.put(friend.get(1), 0);
        }

        return userList;
    }
}
