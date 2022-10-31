package onboarding;

import java.util.*;

public class Problem7 {
    private static HashMap<String, Integer> friendsBook = new HashMap<String, Integer>();
    private static List<String> friendsList = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return ;
    }
    private static void findFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.get(0).contains(user)) {
                friendsList.add(friend.get(1));
            }
            else if (friend.get(1).contains(user)) {
                friendsList.add(friend.get(0));
            }
        }
        return ;
    }
    private static void checkVisitors(List<String> visitors) {
        for (String visitor : visitors ) {
            if (friendsBook.containsKey(visitor)) {
                friendsBook.put(visitor, friendsBook.get(visitor) + 1);
            }
            else {
                friendsBook.put(visitor, 1);
            }
        }
    }
}
