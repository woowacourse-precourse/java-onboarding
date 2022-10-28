package onboarding;

import onboarding.problem2.Decryption;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = Decryption.decrypt(cryptogram);
        return answer;
    }
}
