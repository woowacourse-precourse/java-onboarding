package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        for (int i = cryptogram.length() - 1; i > 0; i--) {
            char currChar = cryptogram.charAt(i);
            char prevChar = cryptogram.charAt(i - 1);

            if (currChar == prevChar) {
                cryptogram = cryptogram.substring(0,i - 1) + cryptogram.substring(i + 1);
            }
        }
        return cryptogram;
    }
}
