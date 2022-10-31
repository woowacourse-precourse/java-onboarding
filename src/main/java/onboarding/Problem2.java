package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (true) {
            int beforeLen = cryptogram.length();
            cryptogram = decode(cryptogram);
            if (beforeLen == cryptogram.length()) {
                return cryptogram;
            }
        }
    }

    private static String decode(String cryptogram) {

        int len = cryptogram.length();

        if (len<2){
            return cryptogram;
        }

        char [] charCrypt = cryptogram.toCharArray();

        for (int i = 1; i < len; i++) {
            if (charCrypt[i - 1] == charCrypt[i]) {
                charCrypt[i-1]=' ';
                charCrypt[i]=' ';
            }
        }

        return new String(charCrypt).replaceAll(" ","");
    }
}
