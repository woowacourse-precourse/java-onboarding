package onboarding;

import java.util.*;

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
            countName();
        }

        private void countName() {
            forms.forEach(this::parseNameAndCount);
        }

        private void parseNameAndCount(List<String> form) {
            String name = form.get(1);
            Set<String> names = new HashSet<>();
            for(int i=1; i<name.length(); i++) {
                names.add(parseName(name, i));
            }
            names.forEach((key) -> counts.put(key, counts.computeIfAbsent(key, v -> 0) + 1));
        }

        private String parseName(String name, int index) {
            return name.charAt(index - 1) + String.valueOf(name.charAt(index));
        }
    }
}
