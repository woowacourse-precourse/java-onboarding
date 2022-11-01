package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> usersFriendsList(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                int index = friend.indexOf(user);
                if (index == 0) {
                    result.add(friend.get(1));
                } else {
                    result.add(friend.get(0));
                }
            }
        }

        return result;
    }

}
