package onboarding;

import onboarding.support.problem7.RecommendationService;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        RecommendationService recommendationService = new RecommendationService(friends, user, visitors);
        return recommendationService.getRecommendationFriends();
    }
}
