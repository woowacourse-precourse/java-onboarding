package onboarding;

import java.util.Stack;

public class Problem2 {
	public static String solution(String cryptogram) {
		Stack<String> stack = new Stack<>();
		String[] cryptogramArray = cryptogram.split("");

		boolean flag = false;
		for (String alphabet : cryptogramArray) {
			if (flag) {
				if (!stack.isEmpty() && stack.peek().equals(alphabet)) {
					continue;
				}
				stack.pop();
				flag = false;
			}
			if (!stack.isEmpty() && stack.peek().equals(alphabet)) {
				flag = true;
				continue;
			}
			stack.push(alphabet);
		}
		if (!stack.isEmpty() && flag) {
			stack.pop();
		}
		return String.join("", stack);
	}
}
