package onboarding;

import onboarding.problem7.FriendRecommendationService;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRecommendationService service = new FriendRecommendationService(user, friends, visitors);
        return service.getRecommendedFriends(5);
    }
}
