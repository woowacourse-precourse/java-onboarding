package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        Stack<Character> stack = new Stack<>();
        for (int i = 1; i < cryptogram.length(); i++) {
            char word =  cryptogram.charAt(i);
            if (stack.empty()) {
                stack.add(word);
            } else {
//                stack = checkSame(stack, word);
            }
        }
        String answer = "answer";
        return answer;
    }

//    public static Stack<Character> checkSame(Stack<Character> stack, char word) {
//        if (stack.peek() == word) {
//            stack.pop();
//        } else {
//            stack.add(word);
//        }
//        return stack;
//    }
}
