package onboarding;

import onboarding.problem2.service.CryptogramDecodeService;

public class Problem2 {
    public static String solution(String cryptogram) {
        return CryptogramDecodeService.decode(cryptogram);
    }
}
