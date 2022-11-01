package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getDecryptedWord(word);
    }

    private static String getDecryptedWord(String word) {
        StringBuilder buffer = new StringBuilder("");
        for (int i = 0; i < word.length(); i++) {
            buffer.append(getChar(word.charAt(i)));
        }
        return buffer.toString();
    }

    private static char getChar(char c) {
        if (Character.isUpperCase(c)) {
            return (char) ('Z' + 'A' - c);
        }
        if (Character.isLowerCase(c)) {
            return (char) ('z' + 'a' - c);
        }
        return c;
    }
}
