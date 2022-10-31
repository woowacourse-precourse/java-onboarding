package onboarding.problem2;

import java.util.Stack;

public class CryptogramTranslation {
	public String translate(String cryptogram) {
		Stack<Character> cryptogramStack = new Stack<>();
		int index = 0;
		while (index < cryptogram.length()) {
			char c = cryptogram.charAt(index);
			if (!cryptogramStack.isEmpty() && cryptogramStack.peek().equals(c)) {
				cryptogramStack.pop();
				index++;
				index = getIndex(cryptogram, index, c);
				continue;
			}
			cryptogramStack.add(c);
			index++;
		}
		return cryptogramStack.stream()
			.map(String::valueOf)
			.reduce((a,b)->a+b)
			.orElse("");
	}

	private static int getIndex(String cryptogram, int index, char c) {
		while (index < cryptogram.length() && cryptogram.charAt(index)==c) {
			index++;
		}
		return index;
	}
}
