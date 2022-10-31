package onboarding;

import java.util.Stack;

/**
 * 기능 1: 연속되는 문자 제거 함수 작성 (Stack 이용)
 * 기능 2: 중복 제거된 Stack을 통해 문자열로 변환하는 함수 작성
 */
public class Problem2 {

    public static Stack<Character> removeDuplicate(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            if (stack.peek() == cryptogram.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(cryptogram.charAt(i));
        }
        return stack;
    }

    public static String convertString(Stack<Character> stack) {
        String result = "";

        for (Character eachChar : stack) {
            result += eachChar;
        }

        return result;
    }


    public static String solution(String cryptogram) {
        Stack<Character> decryptionStack = removeDuplicate(cryptogram);
        return convertString(decryptionStack);
    }
}
