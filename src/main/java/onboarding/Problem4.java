package onboarding;

public class Problem4 {

    private static final int WORD_MAX_LANGE = 1000;
    private static final int WORD_MIN_LANGE = 1;
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";

    public static String solution(String word) {
        if (checkWordLength(word)) {
            return word;
        }

        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            result.append(reversalWord(c));
        }
        return result.toString();
    }

    private static boolean checkWordLength(String word) {
        return !(word.length() >= WORD_MIN_LANGE && word.length() <= WORD_MAX_LANGE);
    }

    private static char reversalWord(char c) {
        if (isNotAlphabet(c)) {
            return c;
        }
        if (Character.isUpperCase(c)) {
            return UPPER.charAt(25 - c + 'A');
        }
        return LOWER.charAt(25 - c + 'a');
    }

    private static boolean isNotAlphabet(char alphabet) {
        return !Character.isAlphabetic(alphabet);
    }
}
