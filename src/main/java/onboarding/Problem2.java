package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static boolean isDuplicated(StringBuilder cryptogram) {
        String str = cryptogram.toString();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                continue;
            }
            if (str.charAt(i - 1) == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
