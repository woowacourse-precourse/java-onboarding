package onboarding;


import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static Map<String, List<String>> buildFriendsGraph(List<List<String>> friends) {
        Map<String, List<String>> friendsGraph = new HashMap<>();
        for (List<String> friend : friends) {
            addFriend(friendsGraph, friend);
        }
        return friendsGraph;
    }
    private static void addFriend(Map<String, List<String>> friendsGraph, List<String> friend) {
        if (friendsGraph.putIfAbsent(friend.get(0), new ArrayList<>(Arrays.asList(friend.get(1)))) != null) {
            friendsGraph.get(friend.get(0)).add(friend.get(1));
        }
        if (friendsGraph.putIfAbsent(friend.get(1), new ArrayList<>(Arrays.asList(friend.get(0)))) != null) {
            friendsGraph.get(friend.get(1)).add(friend.get(0));
        }
    }
}
