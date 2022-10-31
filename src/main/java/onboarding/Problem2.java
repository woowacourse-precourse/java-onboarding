package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> decoder = new Stack<>();
        decoder.push(cryptogram.charAt(0));
        for (int i = 1; i < cryptogram.length(); i++) {
            if (decoder.peek() == cryptogram.charAt(i)) {
                decoder.pop();
            } else {
                decoder.push(cryptogram.charAt(i));
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Character c : decoder) {
            builder.append(c);
        }
        return builder.toString();
    }
}
