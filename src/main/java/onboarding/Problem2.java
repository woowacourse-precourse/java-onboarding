package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] words = cryptogram.toCharArray();

        /*문자 추가, 중복문자 제거*/
        for (int i = 0; i < cryptogram.length(); ++i) {
            if (stack.isEmpty())
                stack.push(words[i]);
            else if (words[i] != stack.peek())
                stack.push(words[i]);
            else
                stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (Character word : stack) {
            sb.append(word);
        }

        String answer = new String(sb);
        return answer;
    }
}
