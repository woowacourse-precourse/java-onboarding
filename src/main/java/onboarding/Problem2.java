package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;

public class Problem2 {
	public static String solution(String cryptogram) {
		check1(cryptogram);
		check2(cryptogram);
		String answer = "answer";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < cryptogram.length(); i++) {
			if (!stack.isEmpty()) {
				if (stack.peek() == cryptogram.charAt(i)) {
					stack.pop();
					continue;
				}
			}
			stack.push(cryptogram.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}
	public static void check1(String cryptogram) throws IllegalArgumentException{
		if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
			throw new IllegalArgumentException("글자수가 없거나 초과하였습니다.");
		}

	}

	public static void check2(String cryptogram) throws IllegalArgumentException{
		if (!cryptogram.matches("^[a-z]*$")) {
			throw new IllegalArgumentException("알파벳 소문자가 아닙니다.");
		}

	}

}