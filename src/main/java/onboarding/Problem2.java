package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {

        Stack<Character> st = new Stack<>();
        char[] list = cryptogram.toCharArray();
        String answer = "";
        for (int i = 0; i < list.length; i++) {
            if(st.size()==0) st.add(list[i]);
            else{
                if(st.peek()==list[i]) st.pop();
                else st.add(list[i]);
            }
        }
        while (!st.isEmpty()) {
            answer = st.pop() + answer;
        }

        return answer;
    }
}
