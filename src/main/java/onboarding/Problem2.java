package onboarding;

import onboarding.problem2.Decryptor;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decryptor decryptor = new Decryptor();
        return decryptor.decrypt(cryptogram);
    }
}
