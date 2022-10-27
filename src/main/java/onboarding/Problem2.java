package onboarding;

import java.util.Stack;

/*
##기능 목록

1. 중복 문자가 있는지 확인
2. 중복 제거
3. 중복 문자가 없을 때까지 반복

 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    public static boolean isDuplicate(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }

    public static String removeDuplicate(String str) {
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                if (stack.peek() == str.charAt(i)) {
                    flag = true;
                } else {
                    if (flag) {
                        stack.pop();
                        flag = false;
                    }
                    stack.push(str.charAt(i));
                }
                if (i == str.length() - 1 && flag) {
                    stack.pop();
                }
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.peek() + result;
            stack.pop();
        }
        return result;
    }
}
