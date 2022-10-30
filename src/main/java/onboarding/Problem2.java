package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if(!stack.isEmpty()){
                if(cryptogram.charAt(i) == stack.peek()){
                    stack.pop();
                }
                else{
                    stack.add(cryptogram.charAt(i));
                }
            }
            else{
                stack.add(cryptogram.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character character : new ArrayList<>(stack)) {
            sb.append(character);
        }

        return sb.toString();
    }
}
