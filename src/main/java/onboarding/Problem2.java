package onboarding;

import java.util.Stack;

public class Problem2 {
	public static String solution(String cryptogram) {
		Stack<String> stack = new Stack<>();
		int index = 0;
		StringBuilder answer = new StringBuilder();

		String[] strings = cryptogram.split("");

		while (index < strings.length) {
			if (!stack.isEmpty() && stack.peek().equals(strings[index])) {
				stack.pop();
			} else {
				stack.add(strings[index]);
			}
			index++;
		}

		for (String s : stack) {
			answer.append(s);
		}

		return answer.toString();
	}
}
