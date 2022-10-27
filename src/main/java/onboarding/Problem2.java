package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static Stack<Character> string_to_stack(String input){
        Stack<Character> input_stack = new Stack<Character>();
        for(int i=0; i<input.length(); i++){
            input_stack.push(input.charAt(i));
        }
        return input_stack;
    }

}
