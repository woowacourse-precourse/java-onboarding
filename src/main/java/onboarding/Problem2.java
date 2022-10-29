package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int length = cryptogram.length();

        while (true) {
            for (int i = 0; i < 26; i++) {
                cryptogram = cryptogram.replaceAll(String.format("[%c]{2}", 'a' + i), "");
            }

            if (length == cryptogram.length()) break;
            length = cryptogram.length();
        }

        return cryptogram;
    }
}
