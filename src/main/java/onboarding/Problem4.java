package onboarding;

public class Problem4 {
    private static final int NO_ALPHABET = 0;
    private static final int LOWER_CASE = -1;
    private static final int UPPER_CASE = 1;
    private static StringBuilder sb;

    public static String solution(String word) {
        sb = new StringBuilder();
        char nowChar;
        for (int i = 0; i < word.length(); i++) {
            nowChar = word.charAt(i);
            transferAlphabet(nowChar);
        }
        return sb.toString();
    }

    private static void transferAlphabet(char alphabet) {
        int charRange = checkCharRange(alphabet);
        char result = alphabet;
        if (charRange != NO_ALPHABET) {
            result = reverseAlphabet(alphabet, charRange);
        }
        sb.append(result);
        return;
    }

    private static char reverseAlphabet(char alphabet, int alphabetCase) {
        double mid = calculateMidAlphabet(alphabetCase);
        double distanceFromMid = mid - alphabet;
        char reversed =  (char)(mid + distanceFromMid);
        return reversed;
    }

    private static double calculateMidAlphabet(int alphabetCase) {
        if (alphabetCase == UPPER_CASE) {
            return ((double)'A'+'Z')/2;
        }
        return ((double)'a'+'z')/2;
    }

    private static int checkCharRange(char nowChar) {
        if (nowChar >= 'A' && nowChar <= 'Z') {
            return UPPER_CASE;
        }
        if (nowChar >= 'a' && nowChar <= 'z') {
            return LOWER_CASE;
        }
        return NO_ALPHABET;
    }

}
