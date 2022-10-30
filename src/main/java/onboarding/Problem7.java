package onboarding;

import java.util.*;

public class Problem7 {
    HashMap<String, Integer> map = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    static List getUserFriends(String user, List<List<String>> friends) {
        List result = new ArrayList();
        for (List<String> friend: friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                if (friend.get(0).equals(user)) {
                    result.add(friend.get(1));
                } else {
                    result.add(friend.get(0));
                }
            }
        }
        return result;
    }
    static void setScoreOfKnown(String user, List<List<String>> friends) {

    }
    static void setScoreOfVisit(String user, List<String> visitors) {

    }
    public static void main(String args[]) {
        List<List<String>> friends = new ArrayList<>(new ArrayList<>());
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"donut", "andole"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"donut", "mrko"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"shakevan", "mrko"})));
        System.out.println(getUserFriends("mrko", friends));
    }
}
