package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        char[] array = cryptogram.toCharArray();

        Stack<Character> stack = new Stack<>();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (stack.peek() == array[i]) {
                stack.pop();
                continue;
            }
            stack.push(array[i]);
        }
        for (int i = 0; i < stack.size(); i++) {
            answer.append(stack.elementAt(i));
        }
        return answer.toString();
    }
}
