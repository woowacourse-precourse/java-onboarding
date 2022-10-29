package onboarding;

import onboarding.problem2.Cryptographer;

public class Problem2 {
    public static String solution(String cryptogram) {
        Cryptographer cryptographer = new Cryptographer();

        return cryptographer.decrypt(cryptogram);
    }
}
