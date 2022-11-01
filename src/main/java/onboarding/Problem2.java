package onboarding;

import java.util.Stack;

public class Problem2 {
    //Stack을 활용하여 cryptogram의 연속된 문자를 제거
    private static Stack<Character> reduceStringByStack(String cryptogram){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < cryptogram.length(); i++){
            if(!stack.empty() && stack.peek() == cryptogram.charAt(i))
                stack.pop();
            else
                stack.push(cryptogram.charAt(i));
        }
        return stack;
    }

    //stack을 String으로 변환
    private static String stackToString(Stack<Character> stack){
        StringBuilder answer = new StringBuilder();
        for (Character character : stack) answer.append(character.toString());
        return answer.toString();
    }

    public static String solution(String cryptogram) {
        Stack<Character> stack = reduceStringByStack(cryptogram);
        return stackToString(stack);
    }
}
