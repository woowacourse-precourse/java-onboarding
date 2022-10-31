package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return "";
    }
    private static char toFrogChar(char c) {
        if (Character.isAlphabetic(c)) {
            // "155, 219" are each sum of uppercase, lowercase alphabet ascii code's start/end.
            // Subtracting original ascii code from it will result in a reversed alphabet.
            c = (char) (Character.isUpperCase(c) ? 155 - c : 219 - c);
        }
        return c;
    }
}
