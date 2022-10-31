package onboarding;

import java.util.Stack;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";
		return answer;
	}

	public static boolean isValid(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static String removeDuplicate(String s) {
		String result = "";

		char duplicateChar = 0;
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (stack.size() == 0) {
				stack.push(c);
				continue;
			}

			if (stack.peek() == c) {
				duplicateChar = c;
				continue;
			}

			if (stack.peek() != c) {
				if (duplicateChar == stack.peek()) {
					stack.pop();
					duplicateChar = 0;
				}

				stack.push(c);
			}
		}

		if (duplicateChar == stack.peek()) {
			stack.pop();
		}

		for (char c : stack) {
			result += c;
		}
		return result;
	}
}
