package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> stack = new Stack<>(); // 스택 자료구조 생성

        // 연속하는 중복 문자 삭제 기능
        for (int i = 0; i < cryptogram.length(); i++) {
            Character alphabet = cryptogram.charAt(i); // 현재 알파벳
            if (stack.empty()) { // 스택이 비어있다면
                stack.push(alphabet);
            } else { // 스택이 비어있지 않은 경우
                if (stack.peek() == alphabet) { // 스택 최상단 알파벳과 현재 알파벳이 같은 경우일 경우, 중복 문자일 경우
                    stack.pop(); // 스택에서 최상단 알파벳을 꺼내어 중복 문자를 제거해준다
                } else { // 중복 문자가 아닐 경우
                    stack.push(alphabet);
                }
            }
        }

        // 연속하는 중복 문자 삭제 결과 반환 기능
        int stackSize = stack.size(); // 스택의 크기
        for (int i = 0; i < stackSize; i++) {
            answer = stack.pop() + answer;
        }

        return answer;
    }
}
