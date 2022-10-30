package onboarding;

import java.util.*;

public class Problem7 {
    HashMap<String, Integer> scoreMap = new HashMap<>();
    static HashMap<String, Boolean> userFriendMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        recordUserFriends(user, friends);
        return answer;
    }
    static void recordUserFriends(String user, List<List<String>> friends) {
        for (List<String> friend: friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                if (friend.get(0).equals(user)) {
                    userFriendMap.put(friend.get(1), true);
                } else {
                    userFriendMap.put(friend.get(0), true);
                }
            }
        }
    }
    static void setScoreOfKnown(String user, List userFriends, List<List<String>> friends) {

    }
    static void setScoreOfVisit(String user, List<String> visitors) {

    }
    public static void main(String args[]) {
        List<List<String>> friends = new ArrayList<>(new ArrayList<>());
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"donut", "andole"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"donut", "mrko"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"shakevan", "mrko"})));
        recordUserFriends("mrko", friends);
        System.out.println(userFriendMap);
    }
}
