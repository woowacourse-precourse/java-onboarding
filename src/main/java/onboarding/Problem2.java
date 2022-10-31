package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(hasDuplicateChar(cryptogram)){
            cryptogram = removeDuplicateChar(cryptogram);
        }

        return cryptogram;
    }

    private static boolean hasDuplicateChar(String cryptogram) {
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private static String removeDuplicateChar(String cryptogram) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            while (isValidRange(cryptogram, i + 1) && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                i = newCharIndex(cryptogram, i);
            }

            if (i < cryptogram.length()) {
                result.append(cryptogram.charAt(i));
            }
        }

        return result.toString();
    }

    private static boolean isValidRange(String cryptogram, int index) {
        return index < cryptogram.length();
    }

    private static int newCharIndex(String cryptogram, int index) {
        char curChar = cryptogram.charAt(index);

        while (isValidRange(cryptogram, index) && cryptogram.charAt(index) == curChar) {
            index++;
        }

        return index;
    }
}
