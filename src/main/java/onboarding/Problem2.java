package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char[] chars = cryptogram.toCharArray();
        char tmp = ' ';
        Stack<Character> stack = new Stack<>();
        for(char ch : chars){
            if(!stack.isEmpty()){
                checkContinuous(stack, ch);
                continue;
            }
            stack.push(ch);
        }

        return answer;
    }

    static void checkContinuous(Stack<Character> stack, char ch){
        if(stack.peek() == ch){
            stack.pop();
        }
    }
}
