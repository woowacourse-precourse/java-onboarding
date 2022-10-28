package onboarding;

public class Problem4 {
    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 1000;
    public static String solution(String word) {
        String answer = "";
        if (isValidInput(word)) {
            answer = "error";
            return answer;
        }
        return answer;
    }

    private static boolean isValidInput(String word) {
        return (isNotNull(word) && isValidRange(word));
    }

    private static boolean isValidRange(String word) {
        return word.length() >= MIN_LENGTH && word.length() <= MAX_LENGTH;
    }

    private static boolean isNotNull(String word) {
        return word != null;
    }
}
