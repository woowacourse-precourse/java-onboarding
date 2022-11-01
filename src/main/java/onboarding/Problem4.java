package onboarding;

public class Problem4 {
    private static final int MIN_WORD_SIZE = 1;
    private static final int MAX_WORD_SIZE = 1000;

    private static final int UPPERCASE_ASCII_START = 65;
    private static final int UPPERCASE_ASCII_END = 90;

    private static final int LOWERCASE_ASCII_START = 97;
    private static final int LOWERCASE_ASCII_END = 122;
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private static void wordRangeValidation(String word) {
        if (word.length() < MIN_WORD_SIZE || word.length() > MAX_WORD_SIZE) {
            throw new IllegalArgumentException("1이상 1000 이하 길이의 문자열만 입력 가능합니다");
        }
    }
}
