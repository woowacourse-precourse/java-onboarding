package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 기능 구현 사항
 * 1. 현재 문자열에서 Stack통해 중복문자 제거
 * 2. Stack -> 문자열 바꾸기
 */
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
