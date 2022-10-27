package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }

    static boolean isOverlab(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.index(i) == cryptogram.index(i+1)) {
                return true;
            }
        }
        return false;
    }
}