package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static final int MAX_RECOMMEND_LIST_SIZE = 5;

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

    private static void makeFriendConnection(Map<String, Set<String>> friendMap, String user, String friend) {
        Set<String> userFriendSet = friendMap.getOrDefault(user, new HashSet<>());
        userFriendSet.add(friend);
        friendMap.put(user, userFriendSet);
    }

    private static Map<String, Integer> getRecommendScore(String user, List<String> visitors, Map<String, Set<String>> friendMap) {
        Map<String, Integer> recommendScore = new HashMap<>();
        Set<String> userFriendSet = friendMap.getOrDefault(user, new HashSet<>());

        scoringFriendsOfFriends(user, friendMap, userFriendSet, recommendScore);
        scoringVisitors(user, visitors, userFriendSet, recommendScore);
        return recommendScore;
    }

    private static void scoringFriendsOfFriends(String user,
                                                Map<String, Set<String>> friendMap,
                                                Set<String> userFriendSet,
                                                Map<String, Integer> recommendScore) {
        for (String friend : userFriendSet) {
            Set<String> friendsListOfFriend = friendMap.get(friend);
            friendsListOfFriend.stream()
                    .filter(friendOfFriend -> isRecommendUser(user, userFriendSet, friendOfFriend))
                    .forEach(recommendUser -> scoringRecommendUser(recommendScore, recommendUser, FRIEND_SCORE));
        }
    }

    private static void scoringVisitors(String user, List<String> visitors, Set<String> userFriendSet, Map<String, Integer> recommendScore) {
        visitors.stream()
                .filter(visitor -> isRecommendUser(user, userFriendSet, visitor))
                .forEach(recommendUser -> scoringRecommendUser(recommendScore, recommendUser, VISITOR_SCORE));
    }

    private static boolean isRecommendUser(String user, Set<String> userFriendSet, String recommendUser) {
        return !(userFriendSet.contains(recommendUser) || recommendUser.equals(user));
    }

    private static void scoringRecommendUser(Map<String, Integer> recommendScore, String visitor, int score) {
        recommendScore.put(visitor, recommendScore.getOrDefault(visitor, 0) + score);
    }

    private static List<String> getRecommendList(Map<String, Integer> recommendScore) {
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(recommendScore.entrySet());
        entries.sort(Problem7::compareScoreAndDictOrder);
        return entries.stream()
                .map(Map.Entry::getKey)
                .limit(MAX_RECOMMEND_LIST_SIZE)
                .collect(Collectors.toList());
    }

    private static int compareScoreAndDictOrder(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int res = o2.getValue().compareTo(o1.getValue());
        if (res != 0) {
            return res;
        } else {
            return o1.getKey().compareTo(o2.getKey());
        }
    }
}
