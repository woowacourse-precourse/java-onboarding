package onboarding;

import java.util.*;

public class Problem2 {

    public static String solution(String cryptogram) {
        return removeDuplicateCharacter(cryptogram);
    }

    // 문자 중복을 제거하는 메서드
    private static String removeDuplicateCharacter(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] chars = cryptogram.toCharArray();
        for (char c : chars) {
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        return makeAnswer(stack);
    }

    // 답 출력 메서드
    private static String makeAnswer(Stack<Character> stack) {
        String answer = "";
        for(Character c : stack)    answer += c;
        return answer;
    }
}
