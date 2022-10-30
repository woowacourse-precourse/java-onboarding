package onboarding;

import java.util.Objects;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        while(!Objects.equals(cryptogram, "")){
            String answer = deleteDuplicates(cryptogram);
            if(Objects.equals(answer, cryptogram))break;
            cryptogram = answer;
        }
        return cryptogram;
    }


    public static String deleteDuplicates(String str){

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        char prev = str.charAt(0);
        st.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {

            if(prev == str.charAt(i)){
                if(!st.empty() && st.peek()==str.charAt(i))st.pop();
            }else{
                st.push(str.charAt(i));
                prev = str.charAt(i);
            }
        }
        while(!st.empty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();

        System.out.println(sb);
        return String.valueOf(sb);
    }
}
