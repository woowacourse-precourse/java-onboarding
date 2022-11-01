package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        //커밋1. 스택 이용하여 중복 제거하기
        Stack<Character> stack = new Stack<>();
        for(int i =0 ; i<cryptogram.length();i++){
            Character c = cryptogram.charAt(i);

            if(stack.isEmpty() || stack.peek() != c) stack.add(c);
            else stack.pop();
        }

        //커밋2. 스택 요소 문자열로 변환하기.
        StringBuffer answer = new StringBuffer(stack.size());
        stack.forEach(s-> answer.append(s));

        return answer.toString();

    }


}