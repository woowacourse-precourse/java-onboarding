package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {

        Stack<Character> stack = new Stack<>();
        // 문자열 탐색
        for (int i = 0; i < cryptogram.length(); i++) {
            char word =  cryptogram.charAt(i);
            // 스택이 비어있으면 문자열 추가
            if (stack.isEmpty()) {
                stack.add(word);
                // 스택이 비어 있지않으면 체크
            } else {
                stack = checkSame(stack, word);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        stack.forEach(ch -> list.add(String.valueOf(ch)));
        String answer = String.join("", list);


        return answer;
    }

    public static Stack<Character> checkSame(Stack<Character> stack, char word) {
        // 스택 최상단 값이 word와 같을 때 최상단 값 제거
        if (stack.peek() == word) {
            stack.pop();
            // 최상단 값과 같지 않을 때 word 추가
        } else {
            stack.add(word);
        }
        return stack;
    }
}
