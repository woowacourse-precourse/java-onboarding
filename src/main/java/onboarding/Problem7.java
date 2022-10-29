package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    static class SNS {
        private String user;
        private Map<String, List<String>> relationship = new HashMap<>();
        private Map<String,Integer> recommendationScore = new HashMap<>();

        public SNS(String user) {
            this.user = user;
        }

        public void addVisitorScore(List<String> visitors) {
            for(String visitor : visitors) {
                Integer orDefault = recommendationScore.getOrDefault(visitor, 0);
                recommendationScore.put(visitor, orDefault+1);
            }
        }

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
