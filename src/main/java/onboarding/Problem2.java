package onboarding;

import java.util.Stack;

public class Problem2 {
    public static Stack<Character> st= new Stack<>();
//    public static StringBuilder answer;

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean checkNotDuplicate(char letter) {
        if (st.isEmpty() || st.lastElement() != letter) {
            return true;
        }

        return false;
    }

    public static void deleteOrPushLetter(char letter) {
        if (checkNotDuplicate(letter)) {
            st.push(letter);
            return;
        }
        st.pop();
    }
}
