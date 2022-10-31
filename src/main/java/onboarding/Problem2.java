package onboarding;


import onboarding.probelm2.CryptogramGenerator;

public class Problem2 {
    public static String solution(String cryptogram) {
        CryptogramGenerator generator = new CryptogramGenerator(cryptogram);
        return generator.generate();
    }
}
