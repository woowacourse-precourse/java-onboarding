package onboarding;

import onboarding.problem7.FriendsService;
import onboarding.problem7.RecommendationSystem;
import onboarding.problem7.VisitorService;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendsService friendsService = new FriendsService();
        VisitorService visitorService = new VisitorService();
        RecommendationSystem recommendationSystem = new RecommendationSystem(friendsService, visitorService);
        return recommendationSystem.doRecommend(user, friends, visitors);
    }
}
