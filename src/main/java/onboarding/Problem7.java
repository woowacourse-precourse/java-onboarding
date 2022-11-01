package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> new_friend = new HashMap<>();
        List<String> old_friend = Collections.emptyList();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                friend.remove(user);
                old_friend.add(friend.get(0));
            }
        }
        return answer;
    }
}
