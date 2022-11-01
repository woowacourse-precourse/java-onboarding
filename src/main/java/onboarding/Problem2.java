package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        String[] strings = cryptogram.split("");

        stringStack(stack, strings);

        for (String a : stack) {
            sb.append(a);
        }

        return String.valueOf(sb);
    }
}
