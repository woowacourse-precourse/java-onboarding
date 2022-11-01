package onboarding;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        NicknameChecker nicknameChecker = new NicknameChecker(forms);
        return nicknameChecker.findRepeatedUser();
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

        private List<String> findRepeatedUser() {
            return forms.stream()
                    .filter(array -> this.isNameRepeated(array.get(1)))
                    .map(array -> array.get(0))
                    .sorted()
                    .collect(toList());
        }

        private boolean isNameRepeated(String name) {
            for (int i = 1; i < name.length(); i++) {
                String key = parseName(name, i);
                if (counts.get(key) >= 2) {
                    return true;
                }
            }
            return false;
        }
    }
}
