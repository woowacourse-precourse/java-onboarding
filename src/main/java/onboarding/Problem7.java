package onboarding;

import java.util.*;

public class Problem7 {
    Map<String, Integer> scoreboard = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> getMyFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                myFriends.addAll(friend);
                myFriends.remove(user);
            }
        }
        return myFriends;
    }

    static List<String> getMyFriends(List<String> users, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (String user : users) {
            myFriends.addAll(getMyFriends(user, friends));
        }

        return myFriends;
    }
    

}
