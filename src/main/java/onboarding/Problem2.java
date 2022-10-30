package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        //받아들인 글자 유효성 검사
        if (cryptogram.length() == 0 || cryptogram == null) {
            return "";
        }

        Stack<Character> stack = new Stack<>();

        stack.push(cryptogram.charAt(0));

        //중복 제거
        for (int i = 1; i < cryptogram.length(); i++) {
            while (!stack.isEmpty() && stack.peek() == cryptogram.charAt(i)) {
                stack.pop();
                if (i == cryptogram.length() - 1 && stack.isEmpty()) {
                    return "";
                }
                i++;
            }
            stack.push(cryptogram.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

}
