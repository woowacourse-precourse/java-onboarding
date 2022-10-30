package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean isRightEmailDomain (String Domain) {
        String rightDomain = "email.com";
        if (Domain.equals(rightDomain)) {
            return true;
        }
        return false;
    }
}
