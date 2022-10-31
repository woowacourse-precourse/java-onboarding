package onboarding;

import onboarding.problem2.CryptogramGenerator;

public class Problem2 {
    public static String solution(String cryptogram) {
        CryptogramGenerator generator = new CryptogramGenerator();
        return generator.generate(cryptogram);
    }
}
