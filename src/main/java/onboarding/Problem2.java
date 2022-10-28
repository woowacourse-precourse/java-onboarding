package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> st = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            if(!st.isEmpty() && st.peek() == c){
                while(!st.isEmpty() && st.peek() == c) {
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!st.isEmpty()) {
            answer.insert(0, st.pop());
        }
        return answer.toString();
    }
}
