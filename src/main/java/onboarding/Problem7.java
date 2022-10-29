package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String >> friendAdjacencyList = new HashMap<>();
    private static Map<String, Integer> friendRecommendationScore = new HashMap<>();
    private static List<String> friendRecommendationResult = new ArrayList<>();
    private static final int SCORE_BY_FRIENDS = 10;
    private static final int SCORE_BY_VISITORS = 1;
    private static final int MAX_RECOMMENDATION_NUM = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        convertToFriendAdjacencyList(friends);
        calculateFriendRecommendationScoreBy(user);
        calculateFriendRecommendationScoreBy(visitors);
        completeFriendRecommendationResult(user);
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

    private static void completeFriendRecommendationResult(String user) {
        String recommendedFriend;

        while (!friendRecommendationScore.isEmpty()) {
            recommendedFriend = "";
            for (String friend : friendRecommendationScore.keySet()) {
                if (hasHigherRecommendationPriority(friend, recommendedFriend)) {
                    recommendedFriend = friend;
                }
            }
            if (!isFriendsOfUser(recommendedFriend, user)) friendRecommendationResult.add(recommendedFriend);
            friendRecommendationScore.remove(recommendedFriend);

            if (friendRecommendationResult.size() >= MAX_RECOMMENDATION_NUM) break;
        }
    }

    private static boolean hasHigherRecommendationPriority(String me, String comparedFriend) {
        Integer scoreOfMe = friendRecommendationScore.get(me), scoreOfComparedFriend = friendRecommendationScore.get(comparedFriend);
        return Objects.equals(comparedFriend, "") || scoreOfMe > scoreOfComparedFriend ||
                Objects.equals(scoreOfMe, scoreOfComparedFriend) && me.compareTo(comparedFriend) < 0; //추천 점수가 같으면 이름순
    }

    private static boolean isFriendsOfUser(String friend, String user) {
        List<String> friendsOfUser = friendAdjacencyList.get(user);
        return friendsOfUser.contains(friend);
    }
}
