package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }

    private List<String> makeFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> relation : friends) {
            if (relation.contains(user)) {
                relation.remove(user);
                friendList.add(relation.get(0));
            }
        }
        return friendList;
    }
}
