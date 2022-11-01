package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String plain = cryptogram;
        int beforeDecryptionLength;
        int afterDecryptionLength;
        do {
            beforeDecryptionLength = plain.length();
            plain = decryption(plain);
            afterDecryptionLength = plain.length();
        } while (beforeDecryptionLength > afterDecryptionLength);

        return plain;
    }

    private static String removeConsecutiveChars(String str, int startIndex) {
        char c = str.charAt(startIndex);
        int endIndex = startIndex + 1;
        for ( ; endIndex < str.length(); endIndex++) {
            if (c != str.charAt(endIndex)) {
                break;
            }
        }

        if (endIndex - startIndex > 1) {
            String targetStr = str.substring(startIndex, endIndex);
            str = str.replace(targetStr, "");
        }

        return str;
    }

    private static String decryption(String cryptogram) {
        String plain = cryptogram;
        int beforeLength;
        int afterLength;
        for (int i = 0; i < plain.length() - 1; i++) {
            beforeLength = plain.length();
            plain = removeConsecutiveChars(plain, i);
            afterLength = plain.length();
            if (afterLength < beforeLength) {
                i--;
            }
        }

        return plain;
    }
}
