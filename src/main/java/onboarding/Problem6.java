package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static class NicknameChecker {
        private final List<List<String>> forms;
        private final Map<String, Integer> counts;

        public NicknameChecker(List<List<String>> forms) {
            this.forms = forms;
            this.counts = new HashMap<>();
        }

        private String parseName(String name, int index) {
            return name.charAt(index - 1) + String.valueOf(name.charAt(index));
        }

    }
}
