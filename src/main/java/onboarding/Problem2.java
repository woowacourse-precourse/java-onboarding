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
}
