package onboarding;

public class Problem4 {
    private static final int LARGE_CHAR = 65 + 90;
    private static final int SMALL_CHAR = 97 + 122;

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (isAlpha(currentChar)) {
                currentChar = changeAlpha(currentChar);
            }
            answer += currentChar;
        }
        return answer;
    }

    private static boolean isAlpha(char currentChar) {
        return ('a' <= currentChar && currentChar <= 'z') || ('A' <= currentChar && currentChar <= 'Z');
    }

    private static char changeAlpha(char ascii) {
        if (ascii <= 90) {
            return (char) (LARGE_CHAR - ascii);
        }
        return (char) (SMALL_CHAR - ascii);
    }
}
