package onboarding;

import onboarding.problem7.RelationshipService;
import onboarding.problem7.InputValueValidator;
import onboarding.problem7.RecommendationSystem;
import onboarding.problem7.VisitorService;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        InputValueValidator inputValueValidator = new InputValueValidator();
        inputValueValidator.validateInputValue(user, friends, visitors);

        RecommendationSystem recommendationSystem = new RecommendationSystem(
                new RelationshipService(),
                new VisitorService());

        return recommendationSystem.doRecommend(user, friends, visitors);
    }
}
