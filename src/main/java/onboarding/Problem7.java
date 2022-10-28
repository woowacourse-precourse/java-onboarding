package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String >> friendAdjacencyList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        convertToFriendAdjacencyList(friends);

        

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void convertToFriendAdjacencyList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String firstFriend = friend.get(0), secondFriend = friend.get(1);
            linkWithFriend(firstFriend, secondFriend);
            linkWithFriend(secondFriend, firstFriend);
        }
    }

    private static void linkWithFriend(String me, String friend) {
        friendAdjacencyList.computeIfAbsent(me, k -> new ArrayList<>());
        friendAdjacencyList.get(me).add(friend);
    }
}
