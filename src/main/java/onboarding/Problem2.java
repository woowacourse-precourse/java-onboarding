package onboarding;

public class Problem2 {

    private static final int CRYPTOGRAM_MIN_LENGTH = 1;
    private static final int CRYPTOGRAM_MAX_LENGTH = 1000;

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean checkCryptogramLength(String cryptogram) {
        return CRYPTOGRAM_MIN_LENGTH <= cryptogram.length()
            && cryptogram.length() <= CRYPTOGRAM_MAX_LENGTH;
    }

    public static boolean checkCryptogramConsistOfLowercase(String cryptogram) {
        for (char cryptogramChar : cryptogram.toCharArray()) {
            if (Character.isUpperCase(cryptogramChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCryptogramOverlap(String cryptogram) {
        char preText = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            if (preText == cryptogram.charAt(i)) {
                return true;
            }
            preText = cryptogram.charAt(i);
        }
        return false;
    }
}
