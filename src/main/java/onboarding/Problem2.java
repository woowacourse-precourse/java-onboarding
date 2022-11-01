package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String compressed = cryptogram;
        do {
            cryptogram = compressed;
            compressed = compress(cryptogram);
        } while (isCompressed(cryptogram, compressed));
        return compressed;
    }

    private static String compress(String input) {
        int inputLength = input.length();
        if (inputLength == 0) {
            return "";
        }
        int targetCharStartIdx = 0;
        int targetCharEndIdx = 0;
        char targetChar = input.charAt(0);
        char currentChar = targetChar;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < inputLength; i++) {
            currentChar = input.charAt(i);
            if (targetChar != currentChar) {
                if (doesTargetCharHasNotSequence(targetCharStartIdx, targetCharEndIdx)) {
                    stringBuilder.append(targetChar);
                }
                targetChar = currentChar;
                targetCharStartIdx = i;
            }
            targetCharEndIdx = i;
        }
        /*
         * 마지막 문자가 연속된 문자열의 끝인지 아닌지 판단한다.
         */
        if (doesTargetCharHasNotSequence(targetCharStartIdx, targetCharEndIdx)) {
            stringBuilder.append(targetChar);
        }
        return stringBuilder.toString();
    }

    private static boolean doesTargetCharHasNotSequence(int targetCharStartIdx, int targetCharEndIdx) {
        if (targetCharStartIdx == targetCharEndIdx) {
            return true;
        }
        return false;
    }

    private static boolean isCompressed(String input, String compressed) {
        if (input.equals(compressed)) {
            return false;
        }
        return true;
    }
}
