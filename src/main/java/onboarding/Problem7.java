package onboarding;

import onboarding.feature7.GroupGenerator;
import onboarding.feature7.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        GroupGenerator groupGenerator = new GroupGenerator(user, friends, visitors);
        Map<String, Integer> recommendationScores = groupGenerator.getRecommendationScores();
        groupGenerator.updateRecommendationScores();

        ResultView resultView = new ResultView(recommendationScores);
        List<String> answer = resultView.getResultIdsFromScores();
        return answer;
    }
}
