package onboarding;

import onboarding.problem2.Decrypt;
import onboarding.problem2.DuplicateProcessor;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decrypt decrypt = new Decrypt(new DuplicateProcessor());
        return decrypt.doDecrypt(cryptogram);
    }
}
