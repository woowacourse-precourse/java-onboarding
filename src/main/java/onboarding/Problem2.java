package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    // 입력 받은 문자열을 주어진 조건에 따라 해독한다.
    static String decrypt(String word) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(stk.isEmpty()) {
                stk.add(c);
                continue;
            }

            // 이전 문자열과 중복인 경우
            if(stk.peek() == c) {
                stk.pop();
                continue;
            }
            stk.add(c);
        }

        while(!stk.isEmpty()) {
            String s = String.valueOf(stk.pop());
            sb.append(s);
        }

        sb = sb.reverse();

        return sb.toString();
    }
}
