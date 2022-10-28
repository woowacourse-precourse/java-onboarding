package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char transformUpper(char upperChar) {
        return (char) (155 - (int) upperChar);
    }

    public static boolean isUpper(char c) {
        return 65 <= (int) c && (int) c <= 90;
    }

    public static boolean isLower(char c) {
        return 97 <= (int) c && (int) c <= 122;
    }

    public static boolean isAlpha(char c) {
        return isUpper(c) || isLower(c);
    }
}
