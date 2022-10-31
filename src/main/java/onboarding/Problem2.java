package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decrypt(cryptogram);
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        String decryptedStr = cryptogram.replaceAll("([a-z])\\1+", "");
        if (cryptogram.length() == decryptedStr.length()) {
            return cryptogram;
        }
        return decrypt(decryptedStr);
    }
}
