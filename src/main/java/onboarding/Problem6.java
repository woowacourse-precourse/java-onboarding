package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean isDuplicated(String n1, String n2) {
        for (int i = 0; i < n1.length() - 1; i++) {
            for (int j = 0; j < n2.length() - 1; j++) {
                if (n1.charAt(i) != n2.charAt(j)) {
                    continue;
                }
                if (n1.charAt(i + 1) == n2.charAt(j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}