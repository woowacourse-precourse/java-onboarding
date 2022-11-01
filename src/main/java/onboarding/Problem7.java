package onboarding;

import java.util.*;

public class Problem7 {

    private static Map<String, List<String>> friendGraph;

    private static void addFriend(String friend1, String friend2) {
        List<String> friendList = friendGraph.getOrDefault(friend1, new ArrayList<>());
        friendList.add(friend2);
        friendGraph.put(friend1, friendList);
    }

    private static void makeGraph(List<List<String>> friends){
        for (List<String> friend : friends){
            addFriend(friend.get(0), friend.get(1));
            addFriend(friend.get(1), friend.get(0));
        }
    }

    private static Map<String, Integer> calculateScore(String user, List<String> visitors) {
        Map<String, Integer> userList = new HashMap<>();
        Set<String> friendSet = new TreeSet<>();
        if (friendGraph.get(user) != null) {
            for (String friend : friendGraph.get(user)) {
                friendSet.add(friend);
            }
        }

        for (String friend : friendSet) {
            for (String friendfriend : friendGraph.get(friend)) {
                if (friendfriend.equals(user) || friendSet.contains(friendfriend))
                    continue;

                int score = userList.getOrDefault(friendfriend, 0);
                score += 10;
                userList.put(friendfriend, score);
            }
        }

        for (String visitor : visitors){
            if (friendSet.contains(visitor)) continue;
            int score = userList.getOrDefault(visitor, 0);
            score += 1;
            userList.put(visitor, score);
        }
        return userList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendGraph = new HashMap<>();
        makeGraph(friends);
        Map<String, Integer> userList = calculateScore(user, visitors);

        ArrayList<String> answer = new ArrayList<>(userList.keySet());
        answer.sort((user1, user2)-> {
            if (userList.get(user1).equals(userList.get(user2)))
                return user1.compareToIgnoreCase(user2);
            else return userList.get(user2) - userList.get(user1);
        });
        return answer;
    }


}
