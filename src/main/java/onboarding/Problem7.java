package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        TreeSet<String> friendSet = new TreeSet<String>();
        TreeSet<String> peopleSet = new TreeSet<String>();

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void findFriends(String user, List<List<String>> friends, TreeSet<String> friendSet) {
        for (List<String> e : friends) {
            int indexOfMe = e.indexOf(user);
            if (indexOfMe == 1) {
                String friendName = e.get(0);
                friendSet.add(friendName);
            } else if (indexOfMe == 0) {
                String friendName = e.get(1);
                friendSet.add(friendName);
            }
        }
    }

}
