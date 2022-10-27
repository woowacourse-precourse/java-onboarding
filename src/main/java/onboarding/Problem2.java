package onboarding;

import java.util.Stack;

public class Problem2 {
    static Stack<Character> stack = new Stack<>();

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * 입력 받은 String을 stack에 저장하면서 연속된 중복값을 제거한다.
     * @param cryptogram
     */
    public static void decoding(String cryptogram) {
        stack.add(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            if(!stack.empty() && stack.peek() == cryptogram.charAt(i)) {
                while(!stack.empty() && stack.peek() == cryptogram.charAt(i)) {
                    stack.pop();
                }
            }
            else stack.add(cryptogram.charAt(i));
        }
    }
}
