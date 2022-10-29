package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> userList = fillUserList(user, friends, visitors);

        userList.get("a");

        return answer;
    }

    public static Map<String, Integer> fillUserList(String user, List<List<String>> friends,
            List<String> visitors) {
        Map<String, Integer> userList = new HashMap<String, Integer>();
        userList.put(user, 0);

        for (List<String> friendRelation : friends) {
            userList.put(friendRelation.get(0), 0);
            userList.put(friendRelation.get(1), 0);
        }

        for (String visitor: visitors) {
            userList.put(visitor, 0);
        }
        return userList;
    }
}
