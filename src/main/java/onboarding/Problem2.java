package onboarding;

import onboarding.problem2.controller.DecryptorDulipcateCryptedText;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = new DecryptorDulipcateCryptedText(cryptogram).getDecryptedText();
        return answer;
    }

}
