package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        char[] sChar = cryptogram.toCharArray();
        Stack<Character> st = new Stack();

        for(int i=0; i<sChar.length; i++){
            if(!st.isEmpty() && st.peek().equals(sChar[i])){
                st.pop();
            }
            else{
                st.push(sChar[i]);
            }
        }
        for (int i = 0; i <st.size() ; i++) {
            answer += st.get(i);
        }
        return answer;
    }
}
