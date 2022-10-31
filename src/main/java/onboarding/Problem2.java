package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return getDecryptedResult(cryptogram);
    }

    private static String getDecryptedResult(String cryptogram) {
        StringBuilder decryptedResultBuilder = new StringBuilder();
        for (int index = 0; index < cryptogram.length();) {
            if (index == cryptogram.length() - 1 || isDifferentFromNext(cryptogram, index)) {
                decryptedResultBuilder.append(cryptogram.charAt(index));
                index += 1;
            }
            else index += 2;
        }

        String decryptedResult = decryptedResultBuilder.toString();
        if (decryptedResult.equals(cryptogram)) return decryptedResult;
        return getDecryptedResult(decryptedResult);
    }

    private static boolean isDifferentFromNext(String cryptogram, int index) {
        return cryptogram.charAt(index) != cryptogram.charAt(index + 1);
    }
}
