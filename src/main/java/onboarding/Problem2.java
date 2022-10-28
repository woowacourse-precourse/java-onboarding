package onboarding;

import onboarding.problem2.CryptogramService;

public class Problem2 {
    public static String solution(String cryptogram) {
        return CryptogramService.decodeCryptogram(cryptogram);
    }
}
