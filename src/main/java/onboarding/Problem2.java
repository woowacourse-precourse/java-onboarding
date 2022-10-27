package onboarding;

public class Problem2 {

    public static void decrypt(String cryptogram) {

    }

    public static String solveCrypto(String cryptogram) {
        String decryptogram = cryptogram;

        while(!decryptogram.equals(cryptogram)) {
            decryptogram = cryptogram;
            decrypt(cryptogram);
        }

        return decryptogram;
    }

    public static String solution(String cryptogram) {
        solveCrypto(cryptogram);

        return cryptogram;
    }
}
