package onboarding;

import problem2.CipherTextDecoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        CipherTextDecoder decoder = new CipherTextDecoder();
        return decoder.decode(cryptogram);
    }
}
