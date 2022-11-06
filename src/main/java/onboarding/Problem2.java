package onboarding;

import onboarding.cryptogram.CryptogramDecoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        return CryptogramDecoder.decrypt(cryptogram);
    }
}
