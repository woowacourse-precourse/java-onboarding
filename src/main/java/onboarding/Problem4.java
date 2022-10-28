package onboarding;

public class Problem4 {
    private static int UPPER_CASE_A = 65;
    private static int UPPER_CASE_Z = 90;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static StringBuilder toStringBuilder(String word) {
        return new StringBuilder(word);
    }

    private static boolean isUpperCase(char character) {
        if (character >= UPPER_CASE_A && character <= UPPER_CASE_Z) {
            return true;
        }
        return false;
    }
}
