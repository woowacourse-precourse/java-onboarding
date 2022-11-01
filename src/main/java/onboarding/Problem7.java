package onboarding;


import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static int MUTUAL_FRIEND_WEIGHT = 10;
    private static int VISITOR_WEIGHT = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsGraph = buildFriendsGraph(friends);
        return calculateRecommendationScore(friendsGraph, visitors, user).entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(e -> e.getKey())
                .limit(5)
                .collect(Collectors.toList());
    }
    private static Map<String, Integer> calculateRecommendationScore(Map<String, List<String>> friendsGraph, List<String> visitors, String user) {
        Map<String, Integer> scoreboard = new HashMap<>();
        List<String> friended = getFriended(friendsGraph, user);
        for (String unfriendedUser : getUnfriended(friendsGraph, user)) {
            int mutualFriends = getFriended(friendsGraph, unfriendedUser)
                    .stream()
                    .filter(friended::contains)
                    .collect(Collectors.toList())
                    .size();
            scoreboard.put(unfriendedUser, mutualFriends * MUTUAL_FRIEND_WEIGHT);
        }
        for (String visitor : visitors) {
            if (!visitor.equals(user) & !friended.contains(visitor)) {
                if (scoreboard.putIfAbsent(visitor, VISITOR_WEIGHT) != null) {
                    scoreboard.put(visitor, scoreboard.get(visitor) + VISITOR_WEIGHT);
                }
            }
        }
        return scoreboard;
    }
    private static List<String> getUnfriended(Map<String, List<String>> friendsGraph, String user) {
        List<String> friended = getFriended(friendsGraph, user);
        return getAllUsers(friendsGraph)
                .stream()
                .filter(u -> !u.equals(user) & !friended.contains(u))
                .collect(Collectors.toList());
    }
    private static List<String> getFriended(Map<String, List<String>> friendsGraph, String user) {
        return friendsGraph.get(user);
    }
    private static Set<String> getAllUsers(Map<String, List<String>> friendsGraph) {
        return friendsGraph.keySet();
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
