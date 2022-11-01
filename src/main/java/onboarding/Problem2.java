package onboarding;

public class Problem2 {
    private static final String MESSAGE = "잘못된 입력입니다.";

    public static String solution(String cryptogram) {

        if (!isOutOfRange(cryptogram) && !isUpperCaseAlphabet(cryptogram)) {
            throw new IllegalArgumentException(MESSAGE);
        }

        return isDuplicate(cryptogram);
    }

    private static boolean isOutOfRange(String cryptogram) {
        return cryptogram.length() > 1000 || cryptogram.length() < 1;
    }

    private static boolean isUpperCaseAlphabet(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();
        for (char c : charArray) {
            return !Character.isUpperCase(c);
        }
        return true;
    }

    private static String isDuplicate(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder(cryptogram);
        int startIdx = 0;
        int endIdx = 0;

        while (true) {
            startIdx = getStartIndex(stringBuilder);
            if (startIdx == -1) {
                return stringBuilder.toString();
            }
            endIdx = getEndIndex(stringBuilder, startIdx);
            stringBuilder.delete(startIdx, endIdx + 1);
        }
    }

    private static int getStartIndex(StringBuilder stringBuilder) {
        int startIdx;

        for (int i = 0; i < stringBuilder.length() - 1; i++) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(i + 1)) {
                startIdx = i;
                return startIdx;
            }
        }
        return -1;
    }

    private static int getEndIndex(StringBuilder stringBuilder, int startIdx) {
        int endIdx = startIdx;

        for (int i = startIdx + 1; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(startIdx)) {
                endIdx++;
            } else {
                break;
            }
        }
        return endIdx;
    }
}
