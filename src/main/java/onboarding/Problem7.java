package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String>> map = new HashMap<>();
    private static Set<String> userFriends = new HashSet<>();
    private static Map<String, Integer> scores = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeRelationships(friends);
        makeUserFriendSet(user);
        add10PointsToKnowTogether(user);
        add1PointToVisitor(user, visitors);
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void makeRelationships(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String from = friend.get(0);
            String to = friend.get(1);
            makeFriendBetweenFromAndTo(from, to);
            makeFriendBetweenFromAndTo(to, from);
        }
    }

    private static void makeFriendBetweenFromAndTo(String from, String to) {
        if (!map.containsKey(from)) {
            List<String> friends = new ArrayList<>();
            friends.add(to);
            map.put(from, friends);
        } else {
            map.get(from).add(to);
        }
    }

    private static void makeUserFriendSet(String user) {
        List<String> friends = map.get(user);
        for (String friend : friends) {
            userFriends.add(friend);
        }
    }

    private static void add10PointsToKnowTogether(String user) {
        List<String> friends = map.get(user);
        for (String friend : friends) {
            List<String> friendOfFriends = map.get(friend);
            add10Points(user, friendOfFriends);
        }
    }

    private static void add10Points(String user, List<String> friendOfFriends) {
        for (String friend : friendOfFriends) {
            if (user.equals(friend)) {
                continue;
            }
            if (userFriends.contains(friend)) {
                continue;
            }
            scores.put(friend, scores.getOrDefault(friend, 0) + 10);
        }
    }

    private static void add1PointToVisitor(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (user.equals(visitor)) {
                continue;
            }
            if (userFriends.contains(visitor)) {
                continue;
            }
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }
}
