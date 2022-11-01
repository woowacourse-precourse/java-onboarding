package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return concatAlphabet(word);
    }

    private static boolean isAlphabetUpperCase(char alphabet) {
        return Character.isUpperCase(alphabet);
    }

    private static int alphabetToAscii(char alphabet) {
        return (int) alphabet;
    }

    private static char asciiToAlphabet(int asciiNumber) {
        return (char) asciiNumber;
    }

    private static char convertAlphabet(char alphabet) {
        int asciiNumber = alphabetToAscii(alphabet);
        if (asciiNumber >= 65 && asciiNumber <= 90 || asciiNumber >= 97 && asciiNumber <= 122)
            if (isAlphabetUpperCase(alphabet)) {
                return asciiToAlphabet(155 - asciiNumber);
            } else {
                return asciiToAlphabet(219 - asciiNumber);
            }
        return alphabet;
    }

    private static String concatAlphabet(String word) {
        StringBuilder sb = new StringBuilder();

        for (char alphabet : word.toCharArray()) {
            sb.append(convertAlphabet(alphabet));
        }

        return sb.toString();
    }
}
