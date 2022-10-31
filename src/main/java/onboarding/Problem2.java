package onboarding;

import onboarding.problemtwo.domain.Cryptogram;

public class Problem2 {
    public static String solution(String cryptogram) {

        Cryptogram cryptogram1 = new Cryptogram(cryptogram);

        String answer = cryptogram1.decode();
        return answer;
    }
}
