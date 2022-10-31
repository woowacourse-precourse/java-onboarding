package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        int length = cryptogram.length();

        boolean check = true;
        while(check) {
            check = false;

            for (int i = 0; i < length - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    cryptogram = cryptogram.substring(0, i).concat(cryptogram.substring(i + 2, length));
                    check = true;
                    i--; length = length-2;
                }
            }
        }

        return cryptogram;
    }
}