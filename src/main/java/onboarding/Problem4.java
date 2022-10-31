package onboarding;

public class Problem4 {
    public static char convertAlpha(char alpha, boolean isLower) {
        int MAX_LOWER = 'a' + 'z';
        int MAX_UPPER = 'A' + 'Z';
        int alphaInt;

        alphaInt = isLower ? MAX_LOWER - (int)alpha : MAX_UPPER - (int)alpha;
        return isLower ? Character.toUpperCase((char)alphaInt) : Character.toLowerCase((char)alphaInt);
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();


        return answer.toString();
    }
}
