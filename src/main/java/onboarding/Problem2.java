package onboarding;

import onboarding.problem2.DecipherCryptogram;

public class Problem2 {
    public static String solution(String cryptogram) {
        DecipherCryptogram decipherCryptogram = new DecipherCryptogram(cryptogram);
        String answer = decipherCryptogram.start();
        return answer;
    }
}