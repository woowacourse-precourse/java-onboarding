package onboarding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserWithFriendsList userWithFriendsList = new UserWithFriendsList(user, friends);
        FriendsWithFriendsList friendsWithFriendsList = new FriendsWithFriendsList(userWithFriendsList, friends);

        Map<String, Integer> userRecommendScoreMap = new HashMap<>();
        plus10RecommendScoreByFriendsOfFriends(friendsWithFriendsList, userRecommendScoreMap);
        plus1RecommendScoreByVisitor(user, visitors, userWithFriendsList, userRecommendScoreMap);

        List<RecommendResult> sortedRecommendResultList = sortRecommendResult(userRecommendScoreMap);

        return sortedRecommendResultList.stream()
                .map(RecommendResult::getName)
                .collect(Collectors.toList());
    }

    private static List<RecommendResult> sortRecommendResult(Map<String, Integer> userRecommendScoreMap) {
        List<RecommendResult> recommendResultList = userRecommendScoreMap.entrySet().stream()
                .map(u -> new RecommendResult(u.getKey(), u.getValue())).sorted(new Comparator<RecommendResult>() {
                    @Override
                    public int compare(RecommendResult user1, RecommendResult user2) {
                        if (user1.getRecommendScore() == user2.getRecommendScore()) {
                            return user1.getName().compareTo(user2.getName());
                        }
                        return user2.getRecommendScore() - user1.getRecommendScore();
                    }
                }).collect(Collectors.toList());
        return recommendResultList;
    }

    public static void plus1RecommendScoreByVisitor(String user, List<String> visitors, UserWithFriendsList userWithFriendsList, Map<String, Integer> userRecommendScoreMap) {
        visitors.stream()
                .forEach(visitor -> {
                    if (!(userWithFriendsList.contains(visitor) || visitor.equals(user))) {
                        userRecommendScoreMap.put(visitor, userRecommendScoreMap.getOrDefault(visitor, 0) + 1);
                    }
                });
    }

    public static void plus10RecommendScoreByFriendsOfFriends(FriendsWithFriendsList friendsWithFriendsList, Map<String, Integer> userRecommendScoreMap) {
        friendsWithFriendsList.getFriendsOfFriendsList()
                .forEach(friend -> {
                    userRecommendScoreMap.put(friend, userRecommendScoreMap.getOrDefault(friend, 0) + 10);
                });
    }
}
