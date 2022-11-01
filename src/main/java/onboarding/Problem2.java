package onboarding;

import onboarding.problem2.Decrypter;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = Decrypter.decrypt(cryptogram);
        return answer;
    }
}
