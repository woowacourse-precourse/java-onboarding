package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return checkContinuous(cryptogram);
    }

    private static String checkContinuous(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
        }
        return stack.stream().map(Object::toString).collect(Collectors.joining());
    }
}
