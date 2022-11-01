package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Problem7 {
    private static final int MAX_RECOMMEND_SIZE = 5;
    private static Map<String, List<String>> map = new HashMap<>();
    private static Set<String> userFriends = new HashSet<>();
    private static Map<String, Integer> scores = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeRelationships(friends);
        makeUserFriendSet(user);
        add10PointsToKnowTogether(user);
        add1PointToVisitor(user, visitors);

        List<String> allRecomendations = getAllRecommendations();
        List<String> answer = getTop5Recommendations(allRecomendations);
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
        if (map.containsKey(user)) {
            List<String> friends = map.get(user);
            for (String friend : friends) {
                userFriends.add(friend);
            }
        }
    }

    private static void add10PointsToKnowTogether(String user) {
        if (map.containsKey(user)) {
            List<String> friends = map.get(user);
            for (String friend : friends) {
                List<String> friendOfFriends = map.get(friend);
                add10Points(user, friendOfFriends);
            }
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

    private static List<String> getAllRecommendations() {
        List<String> list = new ArrayList<>(scores.keySet());
        Collections.sort(list, (o1, o2) -> {
            if (scores.get(o1) == scores.get(o2)) {
                return o1.compareTo(o2);
            }
            return scores.get(o2) - scores.get(o1);
        });
        return list;
    }

    private static List<String> getTop5Recommendations(List<String> allRecommendations) {
        List<String> answer = new ArrayList<>(MAX_RECOMMEND_SIZE);
        for (int i = 0; i < allRecommendations.size(); i++) {
            if (i == MAX_RECOMMEND_SIZE) {
                break;
            }
            answer.add(allRecommendations.get(i));
        }
        return answer;
    }
}
