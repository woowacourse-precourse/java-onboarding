package onboarding;

import onboarding.problem4.AlphabetReverser;

/**
 * Problem 4 기능 목록
 * 1. Alphabet 들을 ascii code 를 사용하여 뒤집는다.
 */
public class Problem4 {
    public static String solution(String word) {
        AlphabetReverser reverser = new AlphabetReverser();
        return reverser.reverse(word);
    }
}
