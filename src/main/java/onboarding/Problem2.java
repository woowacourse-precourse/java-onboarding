package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String oldCryptogram;

        do {
            oldCryptogram = cryptogram;
            cryptogram = cryptogram.replaceAll("(\\p{Lower})\\1+", "");
        } while (!oldCryptogram.equals(cryptogram));
        return cryptogram;
    }
}
