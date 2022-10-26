package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder();
     

        return cryptogram;
    }

    private static String removeConsecutiveDuplicateAlpha(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean duplicateFlag = false;

        for (int idx = 0; idx < cryptogram.length() - 1; idx++) {
            if (cryptogram.charAt(idx) == cryptogram.charAt(idx + 1)) {
                duplicateFlag = true;
            } else if (duplicateFlag) {
                duplicateFlag = false;
            } else {
                stringBuilder.append(cryptogram.charAt(idx));
            }
        }

        if (!duplicateFlag) {
            stringBuilder.append(cryptogram.charAt(cryptogram.length() - 1));
        }

        return stringBuilder.toString();
    }
}
