package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    public static String decryption(String cryptogram) {
        boolean[] isDuplicated = new boolean[cryptogram.length()];
        String result = "";

        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i-1) == cryptogram.charAt(i)) {
                isDuplicated[i-1] = true;
                isDuplicated[i] = true;
            }
        }

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!isDuplicated[i]) {
                result += cryptogram.charAt(i);
            }
        }
        return result;
    }
}
