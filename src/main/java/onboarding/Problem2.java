package onboarding;

public class Problem2 {
    private static final String ERROR_MESSAGE = "Error";

    public static String solution(String cryptogram) {
        if (!isValidRange(cryptogram) || !isLowerCase(cryptogram)) {
            return ERROR_MESSAGE;
        }

        while (true) {
            String decodeString = decodeString(cryptogram);
            if (cryptogram.equals(decodeString)) {
                   break;
            }
            cryptogram = decodeString;
        }
        return cryptogram;
    }

    private static boolean isValidRange(String cryptogram) {
        return cryptogram.length() <= 1000;
    }

    private static boolean isLowerCase(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!Character.isLowerCase(cryptogram.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String decodeString(String cryptogram) {
        for (int i = 0; i< cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                cryptogram = removeDuplicatedCharacter(cryptogram);
            }
        }
        return cryptogram;
    }

    private static String removeDuplicatedCharacter(String cryptogram) {
        return cryptogram.replaceAll("(([a-z])\\2{1,})", "");
    }

}
