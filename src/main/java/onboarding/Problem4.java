package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
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
        if (isAlphabetUpperCase(alphabet)) {
            return asciiToAlphabet(155 - asciiNumber);
        } else {
            return asciiToAlphabet(219 - asciiNumber);
        }
    }

    private static String concatAlphabet(String word) {
        StringBuilder sb = new StringBuilder();

        for (char alphabet : word.toCharArray()) {
            sb.append(convertAlphabet(alphabet));
        }

        return sb.toString();
    }
}
