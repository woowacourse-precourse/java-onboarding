package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        char[] cryptogramChars = cryptogram.toCharArray();
        boolean[] isConsecutive = new boolean[cryptogram.length()];

        for (int i = 1; i < cryptogramChars.length; i++) {
            if (cryptogramChars[i] == cryptogramChars[i - 1]) {
                isConsecutive[i] = true;
                isConsecutive[i - 1] = true;
            }
        }

        return cryptogram;
    }

}
