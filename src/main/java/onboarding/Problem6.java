package onboarding;

import java.util.List;

public class Problem6 {
    private static final int MIN_CREW_NUM = 1;
    private static final int MAX_CREW_NUM = 10000;
    private static final int MIN_EMAIL_SIZE = 11;
    private static final int MAX_EMAIL_SIZE = 20;
    private static final int MIN_NICKNAME_SIZE = 1;
    private static final int MAX_NICKNAME_SIZE = 20;
    private static final String FIXED_DOMAIN = "email.com";
    private static final String EMAIL_PATTERN = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-z]{2,6}$";
    private static final String HANGEUL_PATTERN = "^[가-힣]*$";
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
