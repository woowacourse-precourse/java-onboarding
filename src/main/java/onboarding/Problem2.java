package onboarding;

import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i<cryptogram.length(); i++){
            char currentChar = cryptogram.charAt(i);
            if (stack.empty() || stack.peek() != currentChar){
                stack.push(currentChar);
            }
            else{
                stack.pop();
            }
        }

        String answer = "";
        while(!stack.empty()){
            answer = stack.pop() + answer;
        }

        return answer;
    }
}
