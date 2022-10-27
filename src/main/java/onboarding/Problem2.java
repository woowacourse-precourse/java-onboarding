package onboarding;

import onboarding.domain.Decoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);
        return decoder.getDecodeResult();
    }
}
