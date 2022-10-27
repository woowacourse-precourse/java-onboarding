package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * > 요구사항 </br>
 * 1. 인접한 중복 문자열 삭제(stack을 이용해 매번 순회할 때 마다 중복여부에 따라 추가 /삭제 결정 </br>
 * 2. 알파벳은 소문자로만 이루어져 있음
 */
public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> st = new Stack<>();
        for (int i  = 0; i < cryptogram.length(); ++i) {
            if (!st.empty() && st.peek() == cryptogram.charAt(i)) {
                st.pop();
                continue;
            }
            st.add(cryptogram.charAt(i));
        }
        return st.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""));
    }
}
