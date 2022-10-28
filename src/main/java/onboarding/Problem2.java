package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        if (throwBoundaryException(cryptogram)) {
            return "failed with boundary exception";
        }

        if (throwCapitalException(cryptogram)) {
            return "failed with capital exception";
        }
        
        return cryptogram;
    }

    public static Boolean throwBoundaryException(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return true;
        }
        return false;
    }

    public static Boolean throwCapitalException(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();
        int index;

        for (index = 0; index < charArray.length; index++) {
            if (Character.isUpperCase(charArray[index])) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isContinuous(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();
        char prev = '!';
        int index;

        for (index = 0; index < charArray.length; index++) {
            if (prev != charArray[index]) {
                prev = charArray[index];
                continue;
            }

            if (prev == charArray[index]) {
                return true;
            }
        }
        return false;
    }

}
