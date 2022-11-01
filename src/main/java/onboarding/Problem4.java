package onboarding;

public class Problem4 {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String REVERSE = "zyxwvutsrqponmlkjihgfedcba";

    public static String solution(String word) {
        if (word.length() < 1 || 1000 < word.length()) {
            return word;
        }
        var builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = reverseCharacter(word.charAt(i));
            builder.append(c);
        }
        return builder.toString();
    }

    private static char reverseCharacter(char c) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }
        boolean isUpperCase = false;
        if (Character.isUpperCase(c)) {
            isUpperCase = true;
            c = Character.toLowerCase(c);
        }
        int index = ALPHABET.indexOf(c);
        c = REVERSE.charAt(index);
        if (isUpperCase) {
            return Character.toUpperCase(c);
        }
        return c;
    }
}
