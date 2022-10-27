package onboarding;

import java.util.Stack;

public class Problem2 {
	public static String solution(String cryptogram) {
		Stack<String> stack = new Stack<>();
		String[] cryptogramArray = cryptogram.split("");

		for (String alphabet : cryptogramArray) {
			if (!stack.isEmpty() && alphabet.equals(stack.peek())) {
				stack.pop();
				continue;
			}
			stack.push(alphabet);
		}

		return String.join("", stack);
	}
}
