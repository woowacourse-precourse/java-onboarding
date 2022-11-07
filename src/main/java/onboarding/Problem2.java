package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        answer = overlap(cryptogram);
        return answer;
    }

    public static String overlap(String s) {
        Stack<String> st = new Stack<>();
        ArrayList<Character> sLst = new ArrayList<>();


        for(int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);//getting the character at current index
            sLst.add(currentCharacter);//adding the character to the list
        }
        for(int i=0; i<s.length(); i++) {
            if(st.size() == 0) {
                st.push(String.valueOf(sLst.get(i)));
            } else {
                String c1 = st.peek();
                Character c11 = c1.charAt(0);
                Character c2 = sLst.get(i);
                if(c11 != c2) {
                    st.push(String.valueOf(sLst.get(i)));
                    /** 클린코드 - 코드 한 줄에 점 하나만 허용 했는가?*/
                }
                else {
                    st.pop();
                }
            }

        }

        return String.join("", st);
    }
}
