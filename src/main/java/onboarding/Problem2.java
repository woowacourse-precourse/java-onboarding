package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            //스택에서 꺼낸 문자와 현재 문자를 비교
            if(!stack.isEmpty()){
                if(cryptogram.charAt(i) == stack.peek()){
                    stack.pop(); // 같음으로 스택에서 문자 제거 & 넣으려던 문자 제거
                }
                else{
                    stack.add(cryptogram.charAt(i)); // 다름으로 스택에 문자 집어넣음
                }
            }
            //스택이 비어있을 경우에는 문자 바로 집어넣음
            else{
                stack.add(cryptogram.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character character : new ArrayList<>(stack)) {
            sb.append(character);
        }

        return sb.toString();
    }
}
