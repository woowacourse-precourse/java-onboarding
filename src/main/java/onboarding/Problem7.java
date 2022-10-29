package onboarding;

import onboarding.domain.RecommendBot;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        RecommendBot recommendBot = new RecommendBot(user, friends, visitors);
        return answer;
    }
}
