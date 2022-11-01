package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    private static String charStackToString(Stack<Character> stack){

        return stack
                .stream()
                .map(a -> a.toString())
                .collect(Collectors.joining(""));
    }
    private static String removeRepeatString(String cryptogram){

        Stack<Character> stack = new Stack<>();

        for (char c: cryptogram.toCharArray()){
            if (stack.isEmpty()){
                stack.push(c);
            }else{
                char peekData = stack.peek();
                if(peekData == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        String result = charStackToString(stack);
        return result;
    }

    public static String solution(String cryptogram) {

        String answer = removeRepeatString(cryptogram);
        return answer;
    }
}
