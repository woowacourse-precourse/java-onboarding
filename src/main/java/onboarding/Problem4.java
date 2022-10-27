package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static int isAlphabet(char word) {
        final int BIG_ALPHABET = 1;
        final int SMALL_ALPHABET = 2;
        final int NO_ALPHABET = 3;

        if (word >= 'A' && word <= 'Z') return BIG_ALPHABET;
        if (word >= 'a' && word <= 'z') return SMALL_ALPHABET;
        return NO_ALPHABET;
    }

    private static char convertAlphabet(char word) {
        final int BIG_ALPHABET = 1;
        final int SMALL_ALPHABET = 2;

        if (isAlphabet(word) == BIG_ALPHABET) return (char)('A' + 'Z' - word);
        if (isAlphabet(word) == SMALL_ALPHABET) return (char)('a' + 'z' - word);
        return word;
    }
}
