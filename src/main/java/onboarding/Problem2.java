package onboarding;

import onboarding.problem2.Decoder;

/**
 * Problem 2 function list
 * - decoding cryptogram
 * - search duplication
 * - treat duplication
 * - treat non duplication
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);
        return decoder.decode();
    }
}
