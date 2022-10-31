package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDupli(cryptogram);
    }

    public static String removeDupli(String crypt){
        Stack<Character> stack = new Stack<>();

        for (char ch : crypt.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else
                stack.add(ch);
        }

        return stackToString(stack);
    }

    public static String stackToString(Stack<Character> stack){
        String string = "";
        for(char ch : stack){
            string += ch;
        }
        return string;
    }
}
