/**
 * 클래스 이름
 * - 문제 2
 *
 * 버전정보
 * - openjdk version "11.0.15"
 *
 * 날짜
 * - 2022-10-31
 *
 */

package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        // 복호화 시작
        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            // 스택이 비어있으면 문자 그대로 입력
            // 스택 가장 위에있는 문자와 현재문자를 비교
            // 같으면 중복문자삭제(pop)
            // 다르면 현재문자입력(push)
            if(stack.empty()){
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        // 스택이 LIFO구조이기 때문에 뒤에서부터 문자열을 채워서 만듬
        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }

        return answer;
    }
}
