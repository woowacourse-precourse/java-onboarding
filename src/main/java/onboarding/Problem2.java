package onboarding;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class Problem2 {
    
    private static String decoding(String encodingTxt) {

        Deque<Character> st = new ArrayDeque<>();


        for(char i : encodingTxt.toCharArray()) {
            if (!st.isEmpty() && st.peekLast() == i ) {
                st.pollLast();
            } else {
                st.addLast(i);
            }
        }

        
        return st.stream().map(a -> a.toString()).collect(Collectors.joining(""));
    }


    public static String solution(String cryptogram) {
        if (cryptogram.isEmpty()) {
            return "";
        } else {
            return decoding(cryptogram);
        }
    }
}
