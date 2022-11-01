package onboarding;

import java.util.*;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!st.isEmpty()) {
                if (st.peek() == cryptogram.charAt(i)) {
                    st.pop();
                    continue;
                }
            }
            st.push(cryptogram.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Character str : st) sb.append(str);
        answer = sb.toString();
        return answer;

    }
}
