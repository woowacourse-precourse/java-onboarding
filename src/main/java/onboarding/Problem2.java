package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        if (throwBoundaryException(cryptogram)) {
            return "failed with boundary exception";
        }

        return cryptogram;
    }

    public static Boolean throwBoundaryException(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return true;
        }
        return false;
    }

}
