package onboarding;

import onboarding.problem2.CipherText;
import onboarding.problem2.DecryptionUtil;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(cryptogram == null){
            return "";
        }

        if(cryptogram.length() < 1 || cryptogram.length() > 1000){
            return "";
        }

        CipherText ciphertext = CipherText.builder()
            .value(cryptogram)
            .build();

        return DecryptionUtil.decrypt(ciphertext).getValue();
    }
}
