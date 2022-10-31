package onboarding;

import onboarding.problem2.domain.Decryptor;

public class Problem2 {
    public static String solution(String cryptogram) {
        System.out.println(cryptogram.length());
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
        return decryptor.getCryptogram();
    }
}
