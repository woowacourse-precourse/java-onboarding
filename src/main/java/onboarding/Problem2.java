package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> st = new Stack<>();
        /**
         * 스택을 활용하여
         * 인자로 받은 문자열의 처음 부터 push 하면서
         * peek 가 현재 같은 문자인지 확인하며 push
         * 1. 스택의 peek값과 push할 값이 같으면 삭제
         * 2. 그렇지 않으면 push
         * 3 1-2 반복 .
         */
        st.push(cryptogram.charAt(0));
        for(int i = 1;i<cryptogram.length();i++){
            char cur = cryptogram.charAt(i);
            if(!st.isEmpty() && st.peek().equals(cur))st.pop();
            else st.push(cur);
        }
        StringBuilder stringBuilder = new StringBuilder(st.size());
        while(!st.isEmpty()) {
            stringBuilder.insert(0,(st.peek()));
            st.pop();
        }
        answer = stringBuilder.toString();

        return answer;
    }


}
