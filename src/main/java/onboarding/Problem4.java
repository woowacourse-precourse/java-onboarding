package onboarding;

public class Problem4 {

    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 1000;

    public static String solution(String word) {
        validateRange(word);

        String answer = "";
        return answer;
    }

    private static void validateRange(String input) {
        int inputLength = input.length();
        if (inputLength < MIN_RANGE_NUM || inputLength > MAX_RANGE_NUM) {
            throw new IllegalArgumentException("엄마 말씀은 길이가 1 이상 1000 이하인 문자열이다.");
        }
    }
}
