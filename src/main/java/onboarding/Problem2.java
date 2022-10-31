package onboarding;

import java.util.Stack;

public class Problem2 {

    /**
     * 주어진 char 배열을 crypto로 변환한 stack을 반환합니다.
     * @param chars
     * @return  crypto로 변환한 stack
     */
    public static Stack<Character> makeCrypto(char[] chars) {
        Stack<Character> st = new Stack<>();

        for (char c : chars) {
            if (!st.isEmpty() && st.peek() == c) {
                while (!st.isEmpty() && st.peek() == c) {
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }
        return st;
    }

    public static String solution(String cryptogram) {
        char[] chars = cryptogram.toCharArray();
        Stack<Character> st = makeCrypto(chars);
    }
}
