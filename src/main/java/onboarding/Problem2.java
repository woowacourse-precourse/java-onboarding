package onboarding;

import java.util.Stack;

public class Problem2 {
    /*
     * 중복된 문자열 중복되지 않을 떄 까지 반복해서 삭제
     * */
    // 1. 문자열 내에서 중복된 문자열을 찾는다
    // 2. 제거 후 1번 반복

    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char c : cryptogram.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        answer = sb.reverse().toString();
        return answer;

    }


}
