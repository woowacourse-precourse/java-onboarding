package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (hasStream(cryptogram)) {
            cryptogram = decryption(cryptogram);
        }
        answer = cryptogram;
        return answer;
    }


    public static boolean hasStream(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }
    public static String decryption(String cryptogram) {
        String result = "";
        boolean[] isStream = new boolean[cryptogram.length()];

        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                isStream[i] = true;
                isStream[i+1] = true;
            }
        }

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!isStream[i]) {
                result += cryptogram.charAt(i);
            }
        }
        return result;
    }
}
