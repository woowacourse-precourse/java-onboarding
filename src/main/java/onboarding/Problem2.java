package onboarding;

import onboarding.problem2.Cryptogram;

public class Problem2 {
    public static String solution(String cryptogram) {
        Cryptogram crypto = new Cryptogram(cryptogram);
        return crypto.decipher();
    }
}
