package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
	public static String solution(String cryptogram) {
		Deque<Character> stk = new ArrayDeque<>();

		for (char c : cryptogram.toCharArray()) {
			if (!stk.isEmpty() && stk.getFirst() == c) {
				stk.pop();
			} else {
				stk.push(c);
			}
		}

		StringBuilder answer = new StringBuilder();
		while (!stk.isEmpty()) {
			answer.append(stk.pop());
		}
		return answer.reverse().toString();
	}
}
