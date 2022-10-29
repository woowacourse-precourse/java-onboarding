package onboarding;

public class Problem2 {
    private static final String PATTERN = "([a-z])\\1{1,}";
    private static final String SPACE = "";

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static String removeConsecutiveStrings(String cryptogram) {
        return cryptogram.replaceAll(PATTERN, SPACE);
    }
}
