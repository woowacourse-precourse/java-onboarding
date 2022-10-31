package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    /**
     * 주어진 char 배열을 crypto로 변환한 stack을 반환합니다.
     *
     * @param chars
     * @return crypto로 변환한 stack
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

    /**
     * 주어진 stack을 문자열로 바꿔 리턴합니다.
     *
     * @param st character 타입의 stack
     * @return 변경된 문자열
     */
    public static String convertStackToString(Stack<Character> st) {
        return st.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static String solution(String cryptogram) {
        char[] chars = cryptogram.toCharArray();

        Stack<Character> st = makeCrypto(chars);

        return convertStackToString(st);
    }
}
