package onboarding;

import onboarding.p2.DuplicateStringDecrypt;
import onboarding.p2.StringDecrypt;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringDecrypt stringDecrypt = new DuplicateStringDecrypt();
        return stringDecrypt.getDecryptString(cryptogram);
    }
}
