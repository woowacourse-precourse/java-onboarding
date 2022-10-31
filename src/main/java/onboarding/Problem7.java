package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        int rowLength = friends.size();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                friendList.addAll(friend);
            }
        }
        friendList.removeAll(Collections.singleton(user));
        return friendList;
    }
}
