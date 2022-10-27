package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean isDuplicate(String subject, String target) {
        String word;

        for (int i = 0; i < subject.length() - 1; i++) {
            word = subject.substring(i, i + 2);

            if (target.contains(word)) {
                return true;
            }
        }

        return false;
    }
}
