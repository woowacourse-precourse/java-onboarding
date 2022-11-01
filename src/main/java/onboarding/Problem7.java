package onboarding;

import java.util.List;

import onboarding.friendrecommendationsystem.FriendRecommendationSystem;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRecommendationSystem system
            = new FriendRecommendationSystem(user, friends, visitors);
        return system.getRecommendedUsers();
    }
}
