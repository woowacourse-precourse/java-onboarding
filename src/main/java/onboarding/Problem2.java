package onboarding;

import java.util.Stack;
import java.util.stream.Collector;

public class Problem2 {
    static char temp;

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        cryptogram.chars().forEach(s -> extract((char) s, stack));
        return stack.stream().collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString
        ));
    }
    private static void extract(char s, Stack<Character> stack) {
        if (stack.isEmpty()) {
            stack.push(s);
            return;
        }
        if (stack.peek().equals(s)) {
            temp = stack.pop();
            return;
        }
        if (temp==s){
            return;
        }
        stack.push(s);
    }

}