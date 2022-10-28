package onboarding;

import onboarding.problem2.service.CryptogramService;

public class Problem2 {
    public static String solution(String cryptogram) {
        return CryptogramService.decodeCryptogram(cryptogram);
    }
}
