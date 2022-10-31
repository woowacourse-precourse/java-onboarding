package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        while (true) {
            cryptogram = remove(cryptogram,stack);
        }
        return cryptogram;
    }

    public static String getStringFromStack(Stack<Character> stack) {
        String text = "";
        while(!stack.isEmpty()) {
            text += stack.peek();
            stack.pop();
        }
        StringBuffer answerBuffer = new StringBuffer(text).reverse();
        return answerBuffer.toString();
    }

    public static String remove(String cryptogram, Stack<Character> stack) {
        int dupliCount = 1;
        boolean isDuplicate = false;
        for (int i = 0; i < cryptogram.length(); i++) {
           // 하
            stack.push(cryptogram.charAt(i));
        }
        return getStringFromStack(stack);
    }

}

