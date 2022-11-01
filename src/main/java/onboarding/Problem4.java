package onboarding;

public class Problem4 {
    public static String solution(String word) {
        validate(word);
        return "";
    }

    private static void validate(String word) {
        int length = word.length();
        if (length < 1 || length > 1000) {
            throw new IllegalArgumentException("word는 길이가 1 이상 1,000 이하인 문자열이어야 합니다.");
        }
    }
}
