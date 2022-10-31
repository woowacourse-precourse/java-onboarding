package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {

    private static final int MINIMAL_SIZE = 2;
    private static final int EMAIL_LENGTH = 10;

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new TreeSet<>(Comparator.comparing(s -> s.substring(0, s.length() - EMAIL_LENGTH)));
        for (List<String> form : forms) {
            findDuplicatedNickname(forms, answer, form);
        }
        return toList(answer);
    }

    private static void findDuplicatedNickname(List<List<String>> forms, Set<String> answer, List<String> form) {
        String nickname = form.get(1);
        for (int index = 0; index < nickname.length() - 1; index++) {
            if (isDuplicated(forms, form, nickname, index)) {
                answer.add(form.get(0));
            }
        }
    }

    private static boolean isDuplicated(List<List<String>> forms, List<String> form, String nickname, int index) {
        return forms.stream()
            .anyMatch(anotherForm -> anotherForm.get(1).contains(nickname.substring(index, index + MINIMAL_SIZE)) && !form.equals(
                anotherForm));
    }

    private static ArrayList<String> toList(Set<String> answer) {
        return new ArrayList<>(answer);
    }
}
