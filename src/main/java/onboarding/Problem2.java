package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char start = 'a';
        char end = 'z';

        while (true) {
            int length = cryptogram.length();
            for (char c = start; c <= end; c++) {
                StringBuilder duplicateAlphabet = new StringBuilder();
                duplicateAlphabet.append(c).append("{2,}");
                cryptogram = cryptogram.replaceAll(duplicateAlphabet.toString(), "");
            }

            if (cryptogram.length() == length) {
                break;
            }
        }

        return cryptogram;
    }
}
