package onboarding;

import problem2.Decrytor;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decrytor decryption = new Decrytor(cryptogram);
        String answer = decryption.decrypt();
        return answer;
    }
}
