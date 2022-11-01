package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        TreeSet<String> friendSet = new TreeSet<String>();
        TreeSet<String> peopleSet = new TreeSet<String>();
        findFriends(user, friends, friendSet);
        findPeople(user, friends, visitors, peopleSet);

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

    private static void findPeople(String user, List<List<String>> friends, List<String> visitors, TreeSet<String> friendSet, TreeSet<String> peopleSet) {
        for (List<String> e : friends) {
            peopleSet.add(e.get(0));
            peopleSet.add(e.get(1));
        }
        peopleSet.remove(user);
        peopleSet.removeAll(friendSet);
    }
}
