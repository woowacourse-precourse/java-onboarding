package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            Character c = cryptogram.charAt(i);

            //스택을 통해 연속된 수를 확인
            if(stack.isEmpty() || stack.peek() != c) stack.add(c);
            else stack.pop();
        }

        //스택을 문자열로 변환 후 a-z를 제외한 문자를 제거 후 리턴
        return String.valueOf(stack).replaceAll("[^a-z]","");
    }
}
