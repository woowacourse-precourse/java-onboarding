package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = changeToReverse(word);
        return answer;
    }

    static String changeToReverse(String word) {
        String reverseWord = "";
        for (char alphabet : word.toCharArray()) {
            if ('a' <= alphabet && 'z' >= alphabet) {
                reverseWord += (char)('z' - (alphabet - 'a'));
            } else if ('A' <= alphabet && 'Z' >= alphabet) {
                reverseWord += (char)('Z' - (alphabet - 'A'));
            } else {
                reverseWord += ' ';
            }
        }
        return reverseWord;
    }
}
