package onboarding;

import java.util.Stack;

/*
 * Stack 을 이용해 문자를 처리하는 로직을 추가
 *   1-1. 문자열의 처음 문자부터 끝 문자까지 탐색
 *   1-2. Stack 이 비어있지 않고 Stack 의 제일 위의 문자가 현재 문자와 같을 때
 *       1-2-1. 같지 않은 문자가 나올 때까지 문자를 가리키는 포인터를 이동
 *       1-2-2. Stack 의 제일 위의 문자를 pop()하고 새로운 문자를 add()
 *   1-3. Stack 에 남아있는 문자들을 문자열로 변환하여 반환
 */

public class Problem2 {
    private static int index = 0;
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        while (index < cryptogram.length()) {
            if (isOverlap(cryptogram, stack)) {
                removeOverlap(cryptogram, stack);
                continue;
            }
            stack.push(cryptogram.charAt(index++));
        }

        return stackToString(stack);
    }

    private static boolean isOverlap(String cryptogram, Stack<Character> stack) {
        return !stack.isEmpty() && index < cryptogram.length() && stack.peek().equals(cryptogram.charAt(index));
    }

    private static void removeOverlap(String cryptogram, Stack<Character> stack) {
        while (isOverlap(cryptogram, stack)) {
            index++;
        }
        stack.pop();
    }

    private static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        stack.forEach(sb::append);

        return sb.toString();
    }
}
