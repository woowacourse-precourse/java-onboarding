package onboarding;

import onboarding.problem02.entity.Decoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Decoder decoder = Decoder.form(cryptogram);
        answer = decoder.decryption();
        return answer;
    }
}
