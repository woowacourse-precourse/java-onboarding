package onboarding;

public class Problem4 {
    public static final int MINIMUM_STRING_LENGTH = 1;
    public static final int MAXIMUM_STRING_LENGTH = 1000;
    public static String solution(String word) {
        String answer = "";
        return answer;
        validateRange(word);
    }

    public static void validateRange(String word) {
        if (word.length() < MINIMUM_STRING_LENGTH || MAXIMUM_STRING_LENGTH < word.length()) {
            throw new IllegalArgumentException();
        }
    }
}
