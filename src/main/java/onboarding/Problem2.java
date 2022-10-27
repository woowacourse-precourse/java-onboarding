package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 2. 중복되는 문자열이 없을 때까지 반복
        while (true) {
            String tmp = cryptogram;
            String res = removeDup(cryptogram);
            if (tmp.equals(res)) { break;}
            else { cryptogram = res;}
        }
        return cryptogram;
    }

    // 1. 중복되는 문자열 제거
    public static String removeDup(String str) {
        Stack<Character> stack = new Stack<>();
        int status = 0;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!stack.empty() && stack.peek() == charArray[i]) {
                status = 1;
                if (i == charArray.length - 1) {
                    stack.pop();
                }
            } else {
                if (status == 1) {
                    stack.pop();
                    status = 0;
                }
                stack.push(charArray[i]);
            }
        }
        return stackToString(stack);
    }

    // 3. 스택을 문자열로 변환
    public static String stackToString (Stack < Character > stack){
        StringBuilder res = new StringBuilder();
        for (char s : stack) {
            res.append(s);
        }
        return res.toString();
    }
}
