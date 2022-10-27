package onboarding;

public class Problem4 {
    static final int UPPER_BASE = 155;
    static final int LOWER_BASE = 219;
    static final char START_LOWER = 'a';
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private static char convertAlphabet(char alphabet) {
        if (alphabet == ' ') {
            return alphabet;
        }
        if (alphabet-START_LOWER<0) {
            return (char)(UPPER_BASE-alphabet);
        }
        return (char)(LOWER_BASE-alphabet);
    }
}
