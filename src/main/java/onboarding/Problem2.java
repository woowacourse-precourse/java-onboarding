package onboarding;

import java.util.Stack;

public class Problem2 {
	public static String solution(String cryptogram) {
		Stack<Character> stack = new Stack<Character>();
		char duplicated = ' '; // 중복되는 문자 -> 삭제할 문자
		char top = ' '; // 스택의 top
		char cur = ' '; // cur 은 cryptogram 을 순회할 문자

		for (int i = 0; i < cryptogram.length(); i++) {
			cur = cryptogram.charAt(i);

			if (stack.isEmpty()) { // 스택이 비어있을 때는 무조건 push
				stack.push(cur);
			} else {
				top = stack.peek();
				if (cur != top && cur != duplicated) { // push 할 문자가 스택의 top 과 같지 않으면서 중복 문자도 아닐 때
					stack.push(cur);
					duplicated = ' '; // dup 초기화
				} else if (cur == top) { // push 할 문자와 스택의 top 이 같을 때
					duplicated = top; // dup 업데이트
					stack.pop(); // 중복 문자 제거
				}
			}
		}

		return stackToString(stack);
	}

	private static String stackToString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		for (Character character : stack) {
			sb.append(character);
		}
		return sb.toString();
	}

}
