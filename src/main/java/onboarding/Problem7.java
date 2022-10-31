package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> friend_score = new HashMap<>();
        for (List<String> friend : friends) {
            //
        }
        //return answer;
    }
    public static String findRelationship(String user, List<String> friends) {
        if (friends.contains(user)) {
            if (user.equals(friends.get(0))) return friends.get(1);
            return friends.get(0);
        }
        return null;
    }
}
