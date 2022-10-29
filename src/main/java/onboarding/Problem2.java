package onboarding;


import java.util.Stack;


public class Problem2 {
    private static final Stack<Character> st = new Stack<>();

    public static String solution(String cryptogram) {
        // 1. 중복 문자열을 제거한다.
        removeDuplicateString(cryptogram);

        // 2. 스택의 크기에 따라 적절한 문자열을 반환한다.
        return getResultFromStack();
    }

    private static void removeDuplicateString(String str) {
        for (Character c : str.toCharArray()) {
            if(!st.isEmpty()) {
                Character last = st.peek();
                int duplicate = 0;
                if (!c.equals(last)) {
                    removeDuplicateByStack(last, duplicate);
                }
            }
            st.add(c);
        }

        Character last = st.peek();
        int duplicate = 0;
        removeDuplicateByStack(last, duplicate);
    }

    private static void removeDuplicateByStack(Character last, int cnt) {
        for (int i = st.size(); i > 0; i--) {
            if (last != st.elementAt(i-1)) {
                break;
            }
            cnt += 1;
        }

        if (cnt > 1) {
            for (int i = 0; i < cnt; i++) {
                st.pop();
            }
        }
    }

    private static String getResultFromStack() {
        StringBuilder stringBuilder = new StringBuilder();
        while (!st.isEmpty()) {
            stringBuilder.append(st.pop());
        }
        return stringBuilder.length() == 0 ? "" : stringBuilder.reverse().toString();
    }
}
