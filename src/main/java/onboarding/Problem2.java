package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }


    public static boolean hasDuplicated(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    public static String decryption(String cryptogram) {
        String result = "";
        boolean[] isDuplicated = new boolean[cryptogram.length()];

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
