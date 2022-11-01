package onboarding;

public class Problem4 {

    public static String solution(String word) {

        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            sb.append(reverseAlphabet(c));
        }

        return sb.toString();
    }

    private static char reverseAlphabet(char c) {

        if (!Character.isAlphabetic(c)) {
            return c;
        }

        return (char) ((c & ~31) + 27 - (c & 31));
    }
}
