package onboarding;

import onboarding.p7.BasicRecommendAlgorithm;
import onboarding.p7.RecommendAlgorithm;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        RecommendAlgorithm ra = new BasicRecommendAlgorithm(user);
        return ra.getRecommendUser(friends, visitors);
    }
}
