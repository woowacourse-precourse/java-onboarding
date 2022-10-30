package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

	public static String solution(String cryptogram) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < cryptogram.length(); i++) {

			if (!stack.isEmpty() && stack.peek() == cryptogram.charAt(i)) {
				stack.pop();
			} else {
				stack.add(cryptogram.charAt(i));
			}
		}

		return stack.stream().map(String::valueOf).collect(Collectors.joining());
	}

}