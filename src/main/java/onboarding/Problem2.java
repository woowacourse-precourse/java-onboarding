package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> st = new Stack<Character>();
        boolean isSame = false;
        
        st.push(cryptogram.charAt(0));
        for(int i = 1;i< cryptogram.length();i++){
            if(isSame == true && st.peek()!= cryptogram.charAt(i)){
                st.pop();
                isSame = false;
            }
            if(!st.empty() && st.peek() == cryptogram.charAt(i)){
                st.pop();
                isSame = true;
            }
            st.push(cryptogram.charAt(i));
        }
        if(isSame == true) st.pop();

        return answer;
    }
}
