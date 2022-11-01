package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private enum Score {
        ACQUAINTANCE_WITH_USER(10),
        VISIT_TIMELINE(1);

        private final int value;

        Score(int value) {
            this.value = value;
        }
    }
}
