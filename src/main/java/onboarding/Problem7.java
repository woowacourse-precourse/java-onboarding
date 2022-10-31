package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    private static class Friend {
        private int score;
        private String name;

        public Friend(int score, String name) {
            this.score = score;
            this.name = name;
        }

        public int getScore() {
            return score;
        }
        public String getName() {
            return name;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
