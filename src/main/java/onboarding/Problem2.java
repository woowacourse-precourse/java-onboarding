package onboarding;

import java.util.Stack;

public class Problem2 {
	
	public static Stack<Character> stack = new Stack<>();

	public static String solution(String cryptogram) {
        String answer = "answer";
        
        stack = continuityCheck(cryptogram);
        
        return answer;
    }

	public static Stack<Character> continuityCheck(String cryptogram) {

		for(int i = cryptogram.length() - 1; i >= 0; i--) {
			char character = cryptogram.charAt(i);

			if(stack.isEmpty()) {
				stack.push(character);
				continue;
			}

			if(stack.peek() == character) {
				stack.pop();
				continue;
			}

			stack.push(character);
		}

		return stack;
	}
}
