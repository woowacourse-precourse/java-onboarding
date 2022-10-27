package onboarding;

public class Problem2 {

    private static final int NONE_DUPLICATE = -1;

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static int findDuplicateStrIndex(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return i - 1;
            }
        }
        return NONE_DUPLICATE;
    }
}