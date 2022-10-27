package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        /* Stack(스택)을 사용 */
        Stack<Character> s = new Stack<>();

        /* 중복 문자들을 삭제하는 기능 */
        for (int i = 0; i < cryptogram.length(); i++) {
            /* 스택이 비어있지 않다면 */
            if (!s.isEmpty()) {
                /* 최상단 단어와 담을 단어가 같다면 */
                if (s.peek() == cryptogram.charAt(i)) {
                    s.pop();
                } else {
                    s.push(cryptogram.charAt(i));
                }
            } else {
                s.push(cryptogram.charAt(i));
            }
        }

        return answer;
    }
}
