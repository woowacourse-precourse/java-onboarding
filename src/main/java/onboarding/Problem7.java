package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static final int MAX_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendMap = makeFriendMap(friends);
        Map<String, Integer> recommendScore = getRecommendScore(user, visitors, friendMap);

        return getRecommendList(recommendScore);
    }

    private static Map<String, Set<String>> makeFriendMap(List<List<String>> friends) {
        Map<String, Set<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            makeFriendConnection(friendMap, user1, user2);
            makeFriendConnection(friendMap, user2, user1);
        }
        return friendMap;
    }

    private static List<String> getRecommendList(Map<String, Integer> recommendScore) {
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(recommendScore.entrySet());
        entries.sort((o1, o2) -> {
            int res = o2.getValue().compareTo(o1.getValue());
            if (res != 0) {
                return res;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Map.Entry<String, Integer> stringIntegerEntry : recommendScore.entrySet()) {
            if (stringIntegerEntry.getValue() == 0) continue;
            System.out.println("name: " + stringIntegerEntry.getKey() + " score: " + stringIntegerEntry.getValue());
        }
        return entries.stream()
                .map(Map.Entry::getKey)
                .limit(MAX_SIZE)
                .collect(Collectors.toList());
    }

    private static Map<String, Integer> getRecommendScore(String user, List<String> visitors, Map<String, Set<String>> friendMap) {
        Map<String, Integer> recommendScore = new HashMap<>();
        Set<String> userFriendSet = friendMap.getOrDefault(user, new HashSet<>());

        scoringFriendsOfFriends(user, friendMap, userFriendSet, recommendScore);
        scoringVisitors(visitors, userFriendSet, recommendScore);
        return recommendScore;
    }

    private static void scoringFriendsOfFriends(String user,
                                                Map<String, Set<String>> friendMap,
                                                Set<String> userFriendSet,
                                                Map<String, Integer> recommendScore) {
        for (String friend : userFriendSet) {
            Set<String> friendsListOfFriend = friendMap.get(friend);
            for (String friendOfFriend : friendsListOfFriend) {
                scoringIfRecommendUser(user, userFriendSet, recommendScore, friendOfFriend);
            }
        }
    }

    private static void scoringIfRecommendUser(String user, Set<String> userFriendSet, Map<String, Integer> recommendScore, String friendOfFriend) {
        if (isRecommendUser(user, userFriendSet, friendOfFriend)) {
            recommendScore.put(friendOfFriend, recommendScore.getOrDefault(friendOfFriend, 0) + FRIEND_SCORE);
        }
    }

    private static boolean isRecommendUser(String user, Set<String> userFriendSet, String recommendUser) {
        return !(userFriendSet.contains(recommendUser) || recommendUser.equals(user));
    }

    private static void scoringVisitors(List<String> visitors, Set<String> userFriendSet, Map<String, Integer> recommendScore) {
        for (String visitor : visitors) {
            if (!userFriendSet.contains(visitor)) {
                recommendScore.put(visitor, recommendScore.getOrDefault(visitor, 0) + VISITOR_SCORE);
            }
        }
    }

    private static void makeFriendConnection(Map<String, Set<String>> friendMap, String user, String friend) {
        Set<String> userFriendSet = friendMap.getOrDefault(user, new HashSet<>());
        userFriendSet.add(friend);
        friendMap.put(user, userFriendSet);
    }
}
