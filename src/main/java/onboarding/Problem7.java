package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String, Integer> scoreMap = new HashMap<>();
    static HashMap<String, Boolean> userFriendMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        userFriendMap.put(user, true);
        recordUserFriends(user, friends);
        setScoreOfKnown(user, friends);
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
    static void setScoreOfKnown(String user, List<List<String>> friends) {
        for (List friend: friends) {
            String A = (String) friend.get(0);
            String B = (String) friend.get(1);
            if (userFriendMap.containsKey(A) && !userFriendMap.containsKey(B)) {
                addScore(10, B);
            } else if (!userFriendMap.containsKey(A) && userFriendMap.containsKey(B)) {
                addScore(10, A);
            }
        }
    }
    static void addScore(int Score, String friend) {
        if (scoreMap.containsKey(friend)) {
            scoreMap.put(friend, scoreMap.get(friend) + 10);
        } else {
            scoreMap.put(friend, 10);
        }
    }
    static void setScoreOfVisit(String user, List<String> visitors) {

    }
    public static void main(String args[]) {
        List<List<String>> friends = new ArrayList<>(new ArrayList<>());
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"donut", "andole"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"donut", "jun"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"donut", "mrko"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"shakevan", "andole"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"shakevan", "jun"})));
        friends.add(new ArrayList<>(Arrays.asList(new String[]{"shakevan", "mrko"})));
        userFriendMap.put("mrko", true);
        recordUserFriends("mrko", friends);
        setScoreOfKnown("mrko", friends);
        System.out.println(scoreMap);
    }
}
