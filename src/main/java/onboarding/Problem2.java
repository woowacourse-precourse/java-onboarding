package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        for (int index = cryptogram.length() - 1; index > 0; index--) {
            char currChar = cryptogram.charAt(index);
            char prevChar = cryptogram.charAt(index - 1);

            if (currChar == prevChar) {
                cryptogram = cryptogram.substring(0, index - 1) + cryptogram.substring(index + 1);
            }
        }
        return cryptogram;
    }
}
