package onboarding;

public class Problem4 {

    public static String solution(String word) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            sb.append(reverseAlphabet(c));
        }

        return sb.toString();
    }

    private static char reverseAlphabet(char c) {

        if (!Character.isAlphabetic(c)) {
            return c;
        }

        char base = Character.isLowerCase(c) ? 'a' : 'A';
        return (char) (base + (25 - (c - base)));
    }
}
