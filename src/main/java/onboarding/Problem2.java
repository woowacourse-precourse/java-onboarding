package onboarding;

public class Problem2 {

    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 1000;

    public static String solution(String cryptogram) {
        validateRange(cryptogram);
        validateLower(cryptogram);

        String answer = "answer";
        return answer;
    }

    private static void validateRange(String input) {
        int inputLength = input.length();
        if (inputLength < MIN_RANGE_NUM || inputLength > MAX_RANGE_NUM) {
            throw new IllegalArgumentException("cryptogram은 길이가 1 이상 1000 이하인 문자열이다.");
        }
    }

    private static void validateLower(String input) {
        if (input.toLowerCase() != input) {
            throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 이루어져 있다.");
        }
    }
}
