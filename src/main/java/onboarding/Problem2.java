package onboarding;

import java.util.Stack;

public class Problem2 {

    public static Stack<Character> removeDuplication(String cryptogram){
        Stack<Character> st = new Stack<>();

        for (int i=0; i<cryptogram.length(); i++) {
            Character ch = cryptogram.charAt(i);
            boolean flag = true;
            if(st.empty()) st.push(ch);
            else{
                if(st.peek() != ch) st.push(ch);
                else {
                    while (st.peek() == ch) {
                        if(i+1 < cryptogram.length()) i += 1;
                        else {
                            st.pop();
                            break;
                        }
                        flag = false;
                        ch = cryptogram.charAt(i);
                    }
                }
                if(!flag){
                    st.pop();
                    i -= 1;
                }
            }
        }
        return st;
    }

    public static String reverseString(Stack<Character> st){
        if(st.empty()) return "";

        StringBuffer stringBuffer = new StringBuffer();
        while(!st.empty()) stringBuffer.append(st.pop());

        return stringBuffer.reverse().toString();
    }

    public static String solution(String cryptogram) {
        Stack<Character> st = removeDuplication(cryptogram);
        return reverseString(st);
    }
}
