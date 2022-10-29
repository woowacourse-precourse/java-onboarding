package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] chars = word.toCharArray();
        return getDecryptedWord(word, chars);
    }

    private static String getDecryptedWord(String word, char[] chars) {
        StringBuilder buffer = new StringBuilder("");
        for (char c : chars) {
            buffer.append(getChar(c));
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
