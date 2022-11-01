package onboarding;

import java.util.Iterator;
import java.util.Stack;

public class Problem2 {

    public static String stackToString(Stack<Character> stack) {
        Iterator itr = stack.iterator();
        String temp = "";
        while (itr.hasNext()) {
            temp += itr.next().toString();
        }
        return temp;
    }

    public static String delDuplicated(String target) {
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        if (target.isEmpty()) return "";
        else if (target.length() == 1) return target;

        for (int i = 0; i < target.length(); i++) {
            if (i == target.length() - 1) {
                if (!flag) {
                    stack.push(target.charAt(i));
                }
            }

            else if (target.charAt(i) != target.charAt(i + 1)) {
                if (!flag) stack.push(target.charAt(i));
                else flag = false;
            } else {
                flag = true;
            }
        }

        return stackToString(stack);
    }
    public static String solution(String cryptogram) {
        String answer;

        int i = 0, j = 1;
        int beforeLen, afterLen;

        while (true) {
            beforeLen = cryptogram.length();

            String after = delDuplicated(cryptogram);

            afterLen = after.length();
            if (beforeLen == afterLen) break;
            cryptogram = after;
        }
        answer = cryptogram;

        return answer;
    }
}
