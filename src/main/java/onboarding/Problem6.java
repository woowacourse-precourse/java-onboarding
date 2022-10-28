package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static class NicknameFilter {

        private static final String EMAIL_FORM = "@email.com";

        private String emailParser(String email) {
            return email.replaceAll(EMAIL_FORM, "");
        }
    }
}
