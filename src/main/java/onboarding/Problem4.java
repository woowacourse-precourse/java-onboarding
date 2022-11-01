package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return toFrogString(word);
    }

    private static String toFrogString(String word) {
        StringBuilder frogWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            frogWord.append(toFrogChar(c));
        }
        return frogWord.toString();
    }
    private static char toFrogChar(char c) {
        if (isEnglish(c)) {
            // "155, 219" are each sum of uppercase, lowercase alphabet ascii code's start/end.
            // Subtracting original ascii code from it will result in a reversed alphabet.
            c = (char) (Character.isUpperCase(c) ? 155 - c : 219 - c);
        }
        return c;
    }
    private static boolean isEnglish(char c) {
        return ((65 <= c & c <= 90) | (97 <= c & c <= 122));
    }
}
