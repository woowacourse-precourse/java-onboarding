package onboarding;

import java.util.List;

public class Problem6 {
    private static final int DOMAIN_INDEX = 1;
    private static final String VALID_DOMAIN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean isValidDomain(String email) {
        String[] separatedEmail = email.split("@");
        return separatedEmail[DOMAIN_INDEX].equals(VALID_DOMAIN);
    }
}
