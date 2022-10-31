package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> duplication_stack = changeToStack(cryptogram);
        Stack<Character> removed_stack = removeDuplicate(duplication_stack);
        String answer = makeToString(removed_stack);

        return answer;
    }
    static Stack<Character> removeDuplicate(Stack<Character> duplication_stack) {
        Stack<Character> result_stack = new Stack<Character>();
        while(!duplication_stack.isEmpty()){
            char ch = duplication_stack.pop();
            if(result_stack.isEmpty() || ch != result_stack.peek()){result_stack.push(ch);}
            else if(ch == result_stack.peek()){result_stack.pop();}
        }
        return result_stack;
    }
    static Stack<Character> changeToStack(String cryptogram){
        Stack<Character> temp_stack = new Stack<Character>();
        for(int i=0; i<cryptogram.length(); i++){
            temp_stack.push(cryptogram.charAt(i));
        }
        return temp_stack;
    }
    static String makeToString(Stack<Character> removed_stack) {
        String result_string = "";
        while(!removed_stack.isEmpty()){
            char ch = removed_stack.pop();
            result_string += ch;
        }
        return result_string;
    }
}