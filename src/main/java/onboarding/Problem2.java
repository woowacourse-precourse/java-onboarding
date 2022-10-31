package onboarding;

import problem2.DuplicateCryptogramDecoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        try {
            return DuplicateCryptogramDecoder.decode(cryptogram);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
