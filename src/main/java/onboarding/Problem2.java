package onboarding;

import onboarding.problem2.Cipher;
import onboarding.problem2.Decoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        Cipher cipherText = new Cipher(cryptogram);
        return new Decoder(cipherText).decode();
    }
}
