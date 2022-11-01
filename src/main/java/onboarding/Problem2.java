package onboarding;

import java.util.Stack;

public class Problem2 {

	public static final String ERROR_MESSAGE = "제한 사항을 위배했습니다.";
	public static final int EXCEPTION = -1;

	public static String solution(String cryptogram) {
		Stack<Character> stack = new Stack<Character>();
		char duplicated = ' '; // 중복되는 문자 -> 삭제할 문자
		char top = ' '; // 스택의 top
		char cur = ' '; // cur 은 cryptogram 을 순회할 문자

		if (checkRestrictions(cryptogram) == EXCEPTION) {
			return ERROR_MESSAGE;
		}

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

	/**
	 * 제한사항을 위배했는지 체크하는 메서드
	 * @param cryptogram
	 * @return
	 */
	private static Integer checkRestrictions(String cryptogram) {
		if (!isCryptogramSizeValid(cryptogram)) {
			return EXCEPTION;
		}
		if (!isCryptogramLowerCase(cryptogram)) {
			return EXCEPTION;
		}
		return 0;
	}

	// cryptogram 의 길이가 1 ~ 1000 이 아닌 경우 예외
	private static boolean isCryptogramSizeValid(String cryptogram) {
		if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
			return false;
		}
		return true;
	}

	// cryptogram 이 알파벳 소문자로만 이루어지지 않은 경우 예외
	private static boolean isCryptogramLowerCase(String cryptogram) {
		if (!cryptogram.equals(cryptogram.toLowerCase())) {
			return false;
		}
		return true;
	}

	private static String stackToString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		for (Character character : stack) {
			sb.append(character);
		}
		return sb.toString();
	}

}
