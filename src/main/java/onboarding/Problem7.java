package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> l : friends) {
            if (l.contains(user)) {
                friendList.add(l.get(0).equals(user) ? l.get(1) : l.get(0));
            }
        }
        return friendList;
    }
}
