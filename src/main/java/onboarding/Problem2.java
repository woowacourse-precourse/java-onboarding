package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = cryptogram.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(!stack.isEmpty() && stack.peek() == charArray[i]) {
                stack.pop();
            } else {
                stack.push(charArray[i]);
            }
        }

        return stack.stream().map(c -> Character.toString(c)).collect(Collectors.joining());
    }

}
