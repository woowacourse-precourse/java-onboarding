package onboarding;

import onboarding.problem4.StringReverser;

/**
 * Problem 4 function list
 * - reverse string
 */
public class Problem4 {
    public static String solution(String word) {
        StringReverser reverser = new StringReverser(word);
        return reverser.reverse();
    }
}
