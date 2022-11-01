package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();

        for(Character c : deleteDuplication(cryptogram)){
            answer.append(c);
        }

        return answer.toString();
    }

    /**
     * 중복된 문자열을 제거하는 기능
     */
    public static Stack<Character> deleteDuplication(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(!stack.isEmpty() && stack.peek() == str.charAt(i)){
                stack.pop();
            }else{
                stack.push(str.charAt(i));
            }
        }

        return stack;
    }
}
