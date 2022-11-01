package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void friendsReset(String user, List<List<String>> friends, Map<String, Set<String>> relations, Set<String> newFriends) {
        for (List<String> friend : friends) {
            String from = friend.get(0);
            String to = friend.get(1);

            if (relations.containsKey(from)) {
                relations.get(from).add(to);
            } else {
                relations.put(from, new HashSet<>(Arrays.asList(to)));
            }
            if (relations.containsKey(to)) {
                relations.get(to).add(from);
            } else {
                relations.put(to, new HashSet<>(Arrays.asList(from)));
            }

            if (!from.equals(user) && !to.equals(user)) {
                newFriends.add(from);
                newFriends.add(to);
            }
        }
    }
}
