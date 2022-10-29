package onboarding;


import java.util.Stack;


public class Problem2 {
    private static final Stack<Character> st = new Stack<>();

    public static String solution(String cryptogram) {
        // 1. 중복 문자열을 제거한다.
        removeDuplicateString(cryptogram);
        return "";
    }

    private static void removeDuplicateString(String str) {
        for (Character c : str.toCharArray()) {
            if (!st.isEmpty()) {
                Character last = st.peek();
                if (c.equals(last)) {
                    st.pop();
                    continue;
                }
            }
            st.add(c);
        }
    }
}
