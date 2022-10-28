package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean isLengthZero(String cryptogram) {
        boolean isLengthZero = cryptogram.length() == 0 ? true : false;
        return isLengthZero;
    }

    public static boolean isNotMoreDelete(String cryptogram) {
        boolean isNotMoreDelete = true;
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                return false;
            }
        }
        return isNotMoreDelete;
    }
}
