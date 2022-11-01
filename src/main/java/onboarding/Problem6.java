package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        CheckDuplicateMemberNames checkDuplicateMemberNames = new CheckDuplicateMemberNames(forms);
        checkDuplicateMemberNames.setDuplicatedWords();

        return answer;
    }

    private static class CheckDuplicateMemberNames {

        List<String> duplicatedWords = new ArrayList<>();
        List<List<String>> forms;

        public CheckDuplicateMemberNames(List<List<String>> forms) {
            this.forms = forms;
        }

        public void setDuplicatedWords() {

            for (List<String> form : forms) {

                Set<String> temp = new HashSet<>();

                String name = form.get(1);

                int currentIndex = 0;

                while (currentIndex < name.length() - 1) {

                    temp.add(name.substring(currentIndex, currentIndex + 2));
                    currentIndex++;
                }

                duplicatedWords.addAll(temp);
            }

            duplicatedWords = duplicatedWords.stream()
                    .filter(e -> Collections.frequency(duplicatedWords, e) > 1)
                    .collect(Collectors.toList());
        }
    }
}
