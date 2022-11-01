package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean validateEmailCheck(String email) {
        if (email.endsWith("email.com") &&
                11 <= email.length() && email.length() < 20) {
            return true;
        }

        return false;
    }
}
