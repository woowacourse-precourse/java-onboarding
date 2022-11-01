package onboarding;

import java.util.List;
import onboarding.problem7.RecommendResult;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        RecommendResult recommendResult = new RecommendResult(user, friends, visitors);
        return recommendResult.getResult();
    }
}
