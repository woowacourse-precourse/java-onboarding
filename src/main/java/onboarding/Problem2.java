package onboarding;

public class Problem2 {

    public static final char ALPHABET_START = 'a';
    public static final char ALPHABET_END = 'z';
    public static final String DUPLICATE = "{2,}";

    public static String solution(String cryptogram) {
        while (true) {
            int originLength = cryptogram.length();
            cryptogram = removeDuplicateAlphabet(cryptogram);

            if (isSame(cryptogram, originLength)) {
                break;
            }
        }

        return cryptogram;
    }

    private static String removeDuplicateAlphabet(String cryptogram) {
        for (char c = ALPHABET_START; c <= ALPHABET_END; c++) {
            StringBuilder duplicateAlphabetRegex = getRegex(c);
            cryptogram = cryptogram.replaceAll(duplicateAlphabetRegex.toString(), "");
        }
        return cryptogram;
    }

    private static boolean isSame(String cryptogram, int originLength) {
        return cryptogram.length() == originLength;
    }

    private static StringBuilder getRegex(char alphabet) {
        StringBuilder duplicateAlphabet = new StringBuilder();
        duplicateAlphabet.append(alphabet)
                .append(DUPLICATE);
        return duplicateAlphabet;
    }
}
