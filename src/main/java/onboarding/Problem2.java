package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static boolean canMoreDelete(String cryptogram) {
        if (cryptogram.length() == 0 || cryptogram.length() == 1) return false;

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) return true;
        }

        return false;
    }
}
