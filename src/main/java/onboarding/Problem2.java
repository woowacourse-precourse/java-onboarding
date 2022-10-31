package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int indexOfConsecutiveString = getStartIndexOfConsecutive(cryptogram);
        while (indexOfConsecutiveString >= 0) {
            cryptogram = getRemovedConsecutive(cryptogram, indexOfConsecutiveString);
            indexOfConsecutiveString = getStartIndexOfConsecutive(cryptogram);
        }
        return cryptogram;
    }

    private static int getStartIndexOfConsecutive(String crypto) {
        int result = -1;
        for (int i = 1; i < crypto.length(); i++) {
            if (crypto.charAt(i-1) == crypto.charAt(i))
                result = i-1;
        }
        return result;
    }

    private static String getRemovedConsecutive(String crypto, int startIndex) {
        int lastIndex = startIndex + 2;
        for (int i=lastIndex; i < crypto.length(); i++) {
            if (crypto.charAt(startIndex) != crypto.charAt(i))
                break;
            lastIndex = i;
        }
        return crypto.substring(0, startIndex) + crypto.substring(lastIndex);
    }
}