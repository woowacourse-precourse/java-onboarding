package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String >> friendAdjacencyList = new HashMap<>();
    private static Map<String, Integer> friendRecommendationScore = new HashMap<>();
    private static List<String> friendRecommendationResult = new ArrayList<>();
    private static final int SCORE_BY_FRIENDS = 10;
    private static final int SCORE_BY_VISITORS = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        convertToFriendAdjacencyList(friends);
        calculateFriendRecommendationScoreBy(user);
        calculateFriendRecommendationScoreBy(visitors);
        makeFriendRecommendationResult(user);
        return friendRecommendationResult;
    }

    private static void convertToFriendAdjacencyList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String firstFriend = friend.get(0), secondFriend = friend.get(1);
            linkWithFriend(firstFriend, secondFriend);
            linkWithFriend(secondFriend, firstFriend);
        }
    }

    private static void linkWithFriend(String me, String friend) {
        friendAdjacencyList.putIfAbsent(me, new ArrayList<>());
        friendAdjacencyList.get(me).add(friend);
    }

    private static void calculateFriendRecommendationScoreBy(String user) {
        for (String anotherUser : friendAdjacencyList.keySet()) {
            if (Objects.equals(anotherUser, user)) continue;
            int numberOfOverlapFriends = getNumberOfOverlapFriends(anotherUser, user);
            plusFriendRecommendationScore(anotherUser, SCORE_BY_FRIENDS * numberOfOverlapFriends);
        }
    }

    private static void calculateFriendRecommendationScoreBy(List<String> visitors) {
        for (String visitor : visitors) {
            plusFriendRecommendationScore(visitor, SCORE_BY_VISITORS);
        }
    }

    private static int getNumberOfOverlapFriends(String me, String user) {
        int number = 0;
        List<String> friendsOfUser = friendAdjacencyList.get(user);

        for (String friend : friendsOfUser) {
            if (friendAdjacencyList.get(me).contains(friend)) number++;
        }
        return number;
    }

    private static void plusFriendRecommendationScore(String friend, int plusScore) {
        friendRecommendationScore.putIfAbsent(friend, 0);
        int updatedScore = friendRecommendationScore.get(friend) + plusScore;
        friendRecommendationScore.replace(friend, updatedScore);
    }

    private static void makeFriendRecommendationResult(String user) {
    }
}
