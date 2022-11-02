package onboarding.problem2;

import java.util.Stack;
import java.util.stream.Collectors;

public class Cryptogram {

	private final String encrypted;

	public Cryptogram(String encrypted) {
		this.encrypted = encrypted;
	}

	public String decrypt() {
		String decrypted = encrypted;
		while (!decrypted.equals(decryptOnce(decrypted))) {
			decrypted = decryptOnce(decrypted);
		}
		return decrypted;
	}

	private String decryptOnce(String encrypted) {
		Stack<Character> stack = new Stack<>();
		char previous = '\0';
		for (char c : encrypted.toCharArray()) {
			if (previous == c && !stack.isEmpty()) {
				stack.pop();
			}
			if (previous != c) {
				stack.push(c);
			}
			previous = c;
		}
		return stack.stream()
			.map(String::valueOf)
			.collect(Collectors.joining());
	}
}
