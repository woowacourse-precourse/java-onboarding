package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> st = new Stack<Character>();
        boolean isSame = false;

        st.push(cryptogram.charAt(0));
        for(int i = 1;i< cryptogram.length();i++){
            st.push(cryptogram.charAt(i));
        }
        return answer;
    }
}
