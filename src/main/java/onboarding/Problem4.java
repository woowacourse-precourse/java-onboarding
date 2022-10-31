package onboarding;

public class Problem4 {
    private static final char[] lowerChars = new char[26];

    static {
        for (int i = 0; i < lowerChars.length; i++) {
            lowerChars[i] = (char) ('z' - i);
        }
    }

    private static String convertWord(String word) {
        StringBuilder builder = new StringBuilder();
        for (char chr : word.toCharArray()) {
            char convertedChar = chr;
            if (chr >= 'a' && chr <= 'z') {
                convertedChar = lowerChars[chr - 'a'];
            } else if (chr >= 'A' && chr <= 'Z') {
                convertedChar = Character.toUpperCase(lowerChars[chr - 'A']);
            }
            builder.append(convertedChar);
        }
        return builder.toString();
    }

    public static String solution(String word) {
        return convertWord(word);
    }
}
