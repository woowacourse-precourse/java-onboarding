package onboarding;

import java.util.Stack;

public class Problem2 {
	
	public static Stack<Character> stack = new Stack<>();

	public static String solution(String cryptogram) {
        String answer = "answer";
        
        stack = continuityCheck(cryptogram);
        
        answer = stringBuild(stack).toString();
        
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

    public static StringBuilder stringBuild(Stack<Character> stack) {
        StringBuilder builder = new StringBuilder();

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder;
    }
}
