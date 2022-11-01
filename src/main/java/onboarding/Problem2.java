package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        char before = '@';

        for (int i = 0; i < cryptogram.length(); i++) {
            Character word = cryptogram.charAt(i);
            if (!stack.empty()){
                if (stack.peek() == word || before == word){
                    stack.pop();
                }
                else {
                    stack.push(word);
                }
                before = word;
            }
            else{
                stack.push(word);
            }
        }

        while (!stack.empty())
            answer += stack.pop();

        StringBuffer sb = new StringBuffer(answer);
        String reversedStr = sb.reverse().toString();

        return reversedStr;
    }
}
