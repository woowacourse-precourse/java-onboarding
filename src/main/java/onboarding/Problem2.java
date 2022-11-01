package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        String pattern = "([a-z])\\1+";
        String oldCryptogram = cryptogram;
        String newCryptogram = cryptogram.replaceAll(pattern, "");

        while (!oldCryptogram.equals(newCryptogram)) {
            oldCryptogram = newCryptogram;
            newCryptogram = newCryptogram.replaceAll(pattern, "");
        }

        return newCryptogram;
    }
}
