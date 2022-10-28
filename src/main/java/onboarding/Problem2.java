package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(); //정답 출력
        Stack<Character> stack = new Stack<>(); //스택 선언
        stack.add(cryptogram.charAt(0));// 스택에 첫 문자를 담아 놓는다
        for (int i = 1; i < cryptogram.length(); i++){ // 두번쨰 문자부터 시작한다.
            if (stack.peek() == cryptogram.charAt(i)) stack.pop(); // 스택의 마지막 값과 값다면 제거
            else stack.push(cryptogram.charAt(i)); // 아니라면 push()
        }
        while (!stack.isEmpty()){ // 스택이 텅 빌때까지
            answer.insert(0, stack.pop()); // 스트링 빌더에 스택 값을 넣는다.
        }
        return answer.toString(); //문자열로 변환
    }
}
