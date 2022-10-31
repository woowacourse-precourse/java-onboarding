package onboarding;

import model.Encryption;

public class Problem2 {
    public static String solution(String cryptogram) {
        Encryption decryption = new Encryption(cryptogram);
        return decryption.getDecryptedText();
    }
}
