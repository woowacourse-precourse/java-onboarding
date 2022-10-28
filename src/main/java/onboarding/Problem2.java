package onboarding;

import onboarding.problem2.CryptogramService;
import onboarding.problem2.CryptogramValidator;

public class Problem2 {
    public static String solution(String cryptogram) {
        CryptogramValidator.validate(cryptogram);
        return CryptogramService.decodeCryptogram(cryptogram);
    }
}
