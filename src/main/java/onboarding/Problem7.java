package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriends = getUserFriends(user, friends);

        return answer;
    }
    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriendSet = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {

            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            if (name1.equals(user)) {
                userFriendSet.add(name2);
            } else if (name2.equals(user)) {
                userFriendSet.add(name1);
            }


        }

        List<String> userFriends = new ArrayList<>(userFriendSet);
        return userFriends;
    }



}
