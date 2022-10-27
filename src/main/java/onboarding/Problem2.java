package onboarding;

import java.util.Iterator;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < cryptogram.length(); i++) {
            char now = cryptogram.charAt(i);
            if(stack.isEmpty()) stack.push(now);
            else {
                char top = stack.pop();
                if(top == now) continue;
                stack.push(top);
                stack.push(now);
            }
        }

        Iterator<Character> iterator = stack.listIterator();
        StringBuilder stringBuilder = new StringBuilder();

        while(iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        return stringBuilder.toString();
    }
}
