package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {

    public static HashMap<String, HashSet<String>> friendList = new HashMap<>();
    public static HashMap<String, Integer> scoreboard = new HashMap<>();

    private static List<String> getRecommendedFriends(String user) {

    }

    private static void setFriendList(List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String user1 = friends.get(i).get(0);
            String user2 = friends.get(i).get(1);
            HashSet<String> user1List = friendList.get(user1);
            HashSet<String> user2List = friendList.get(user2);
            user1List.add(user2);
            user2List.add(user1);
            friendList.put(user1, user1List);
            friendList.put(user2, user2List);
        }
    }

    private static void setVistors(String user, List<String> visitors) {
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setFriendList(friends);
        setVistors(user, visitors);
        List<String> answer = getRecommendedFriends(user);
        return answer;
    }
}
