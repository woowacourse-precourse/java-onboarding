package onboarding;

public class Problem4 {
    private static final int UPPERCASE_NUMBER = 155;
    private static final int LOWERCASE_NUMBER = 219;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    public static String solution(String word) {
        validityChecker(word);

        String answer = "";
        return answer;
    }

    private static void validityChecker(String word) {
        if (isNotValidWord(word)) {
            throw new IllegalArgumentException("Not valid word");
        }
    }
    private static boolean isNotValidWord(String word) {
        return word.length() < MIN_LENGTH || MAX_LENGTH < word.length();
    }
}
