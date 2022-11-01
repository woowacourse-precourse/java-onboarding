package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> alreadyFriend = new ArrayList<>();
        List<List<String>> candidate = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.get(0) == user) {
                alreadyFriend.add(friend.get(1));
            } else if (friend.get(1) == user) {
                alreadyFriend.add(friend.get(0));
            } else {
                candidate.add(friend);
            }
        }

        Map<String, Integer> newFriend = getNewFriendMap(alreadyFriend, candidate, visitors);
        List<String> answer = suggestion(newFriend);
        return answer;
    }
}
