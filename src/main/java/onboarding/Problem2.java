package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        int i = 0;
        while (i < cryptogram.length() - 1) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                cryptogram = cryptogram.replaceFirst(cryptogram.substring(i, i + 2), "");
                i -= 1;
            } else {
                i += 1;
            }
        }

        answer = cryptogram;
        return answer;
    }
}
