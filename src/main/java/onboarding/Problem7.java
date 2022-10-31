package onboarding;

import java.util.*;

public class Problem7 {
    private static HashSet<String> userFriend;
    private static HashMap<String, Integer> friendList;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        userFriend = new HashSet<>();
        friendList = new HashMap<>();
        userFriend.add(user);

        for (List l : friends) {
            String s1 = (String) l.get(0);
            String s2 = (String) l.get(1);

            addFriendNetwork(user, s1, s2);

        }

        return answer;
    }

    private static void addFriendNetwork(String user, String firstPerson, String secondPerson) {
        if (firstPerson.equals(user)) {
            userFriend.add(secondPerson);
            return;
        }
        if (secondPerson.equals(user)) {
            userFriend.add(firstPerson);
            return;
        }
        if (!friendList.containsKey(firstPerson)) {
            friendList.put(firstPerson, 0);
        }
        if (!friendList.containsKey(secondPerson)) {
            friendList.put(secondPerson, 0);
        }
    }
}