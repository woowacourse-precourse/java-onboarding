package onboarding;

import problem2.Decoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);

        return decoder.decode();
    }
}
