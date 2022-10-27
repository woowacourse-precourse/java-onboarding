package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] cryptogramCharArray = cryptogram.toCharArray();
        Stack<Character> stack = new Stack<>();
        char beforeCryptogramChar;

        stack.push(cryptogramCharArray[0]);
        for (int cryptogramCharArrayIndex = 1; cryptogramCharArrayIndex < cryptogramCharArray.length; ){
            beforeCryptogramChar = stack.peek();
            if (beforeCryptogramChar == cryptogramCharArray[cryptogramCharArrayIndex]) {
                stack.pop();
                while (cryptogramCharArrayIndex < cryptogramCharArray.length &&
                        beforeCryptogramChar == cryptogramCharArray[cryptogramCharArrayIndex]) {
                    cryptogramCharArrayIndex += 1;
                }
                if (cryptogramCharArrayIndex >= cryptogramCharArray.length)
                    break;
                continue;
            }
            stack.add(cryptogramCharArray[cryptogramCharArrayIndex]);
            cryptogramCharArrayIndex += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack)
            sb.append(c);
        return sb.toString();
    }
}
