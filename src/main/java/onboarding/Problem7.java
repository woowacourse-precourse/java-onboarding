package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> closeFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                closeFriends.add(friends.get(i).get(0));
            }
        }
        return answer;
    }
}
