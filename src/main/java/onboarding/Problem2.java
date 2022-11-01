package onboarding;

import java.util.Stack;

/***
 * 기능 목록
 *
 * 1. 연속하는 중복문자 제거 기능
 *
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer = decryption(cryptogram);
    }

    public static String decryption(String cryptogram) {
        String ans = cryptogram;
        Stack<Character> stack = new Stack<>();

        for (char c : ans.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        ans = stack.toString();
        ans = ans.replaceAll("\\[", "");
        ans = ans.replaceAll("\\]", "");
        ans = ans.replaceAll(",", "");
        ans = ans.replaceAll(" ", "");

        return ans;
    }
}
