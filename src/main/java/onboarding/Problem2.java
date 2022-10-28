package onboarding;

import onboarding.problem2.Decryption;
import onboarding.problem2.Validation;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        try {
            Validation.validate(cryptogram);
            answer = Decryption.decrypt(cryptogram);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
