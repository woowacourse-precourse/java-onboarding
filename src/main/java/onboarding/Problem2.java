package onboarding;

import onboarding.problem2.Decryptor;

public class Problem2 {

    public static String solution(String cryptogram) {
        Decryptor crypto = new Decryptor();
        return crypto.decodedCrypto(cryptogram);
    }

}
