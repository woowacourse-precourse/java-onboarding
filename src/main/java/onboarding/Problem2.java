package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> s = new Stack<>();


        for (Character c: cryptogram.toCharArray()) {
            if (!s.empty() && s.peek() == c) {
                s.pop();
                continue;
            }
            s.push(c);
        }


        while (!s.empty()) {
            answer.insert(0, s.pop());
        }

        return answer.toString();
    }
}
