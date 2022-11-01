package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        Stack<Character> cryptogram_stack = string_to_stack(cryptogram);
        Stack<Character> remove_duplicate_from_cryptogram_stack = remove_duplicate(cryptogram_stack);
        String answer = stack_to_string(remove_duplicate_from_cryptogram_stack);
        return answer;
    }

    static String stack_to_string(Stack<Character> input_stack){
        String input_stack_to_string = "";
        while(!input_stack.isEmpty()){
            input_stack_to_string += input_stack.pop();
        }
        return input_stack_to_string;
    }

    static Stack<Character> remove_duplicate(Stack<Character> input_stack){
        Stack<Character> removed_stack = new Stack<Character>();
        while(!input_stack.isEmpty()) {
            char input_char = input_stack.pop();
            if(removed_stack.isEmpty() || input_char != removed_stack.peek()) removed_stack.push(input_char);
            else if(input_char == removed_stack.peek()){
                removed_stack.pop();
            }
        }
        return removed_stack;
    }

    static Stack<Character> string_to_stack(String input){
        Stack<Character> input_stack = new Stack<Character>();
        for(int i=0; i<input.length(); i++){
            input_stack.push(input.charAt(i));
        }
        return input_stack;
    }

}
