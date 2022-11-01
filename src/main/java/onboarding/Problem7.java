package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    static List<String> findFriends(String user, <List<List<String>> friends) {
        List<String> alreadyFriends = new ArrayList<>();
        for (List<String> relationship : friends) {
            if (!relationship.get(0).equals(user) && !relationship.get(1).equals(user))
                continue;
            if (relationship.get(0).equals(user)) {
                alreadyFriends.add(relationship.get(1));
                continue;
            }
            if (relationship.get(1).equals(user)) {
                alreadyFriends.add(relationship.get(0));
            }
        }
        return alreadyFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
