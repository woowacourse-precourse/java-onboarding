package onboarding;
import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> st = new Stack<>();
        char c;
        for (int i = 0; i < cryptogram.length(); i++) {
            c = cryptogram.charAt(i);
            if(!st.empty() && st.peek() == c) st.pop();
            else st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        return sb.toString();
    }
}