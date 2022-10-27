package onboarding;

import java.util.Stack;

public class Problem2 {
    static String decrypt(String crypt){
        Stack<Character> stack = new Stack<>();
        stack.add(crypt.charAt(0));
        char top = stack.peek();
        for(int i= 1; i < crypt.length(); i++) {
            if (crypt.charAt(i) == stack.peek()) {
                top = stack.peek();
                stack.pop();
            }
            if (crypt.charAt(i) != top) {
                stack.add(crypt.charAt(i));
                top = stack.peek();
            }
        }
        StringBuilder ret_value = new StringBuilder();
        for (Character character : stack) {
            ret_value.append(character.toString());
        }
        //System.out.println(ret_value);
        return ret_value.toString();
    }

    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }
}
