package onboarding;

import onboarding.problem2.domain1.Decryptor;

public class Problem2 {
    public static String solution(String cryptogram) {
        final Decryptor decryptor = new Decryptor(cryptogram);
        
        decryptor.decrypte();
        
        return decryptor.decryptedCryptogram();
    }
}
