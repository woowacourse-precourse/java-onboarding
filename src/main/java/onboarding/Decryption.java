package onboarding;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Decryption {
	private static final int MAX_INPUT_LENGTH = 1000;
	private static final int MIN_INPUT_LENGTH = 1;

	private final String cryptogram;

	public Decryption(String cryptogram) {
		validateInput(cryptogram);
		this.cryptogram = cryptogram;
	}

	private void validateInput(String cryptogram) {
		validateInputLength(cryptogram);
		validateLowerCase(cryptogram);
	}

	private void validateInputLength(String cryptogram) {
		if (cryptogram.length() > MAX_INPUT_LENGTH || cryptogram.length() < MIN_INPUT_LENGTH) {
			throw new IllegalArgumentException("암호문의 길이는 1이상 100이하 입니다.");
		}
	}

	private void validateLowerCase(String cryptogram) {
		if (!StringPatterUtils.isFormedLowerCase(cryptogram)) {
			throw new IllegalArgumentException("암호문은 알파벳 소문자로만 이루어져야 합니다.");
		}
	}

	public String decipher() {
		StringBuilder stringBuilder = new StringBuilder();
		Deque<Character> deque = getNonDuplicateCharacter();
		while (!deque.isEmpty()) {
			Character obj = deque.pollFirst();
			stringBuilder.append(obj);
		}
		return stringBuilder.toString();
	}

	private Deque<Character> getNonDuplicateCharacter() {
		Deque<Character> deque = new LinkedList<>();
		char[] chars = cryptogram.toCharArray();
		deque.add(chars[0]);
		char pre = chars[0];
		for (int i = 1; i < chars.length; i++) {
			if (pre != chars[i]) {
				deque.addLast(chars[i]);
				pre = chars[i];
				continue;
			}
			pre = chars[i];
			deque.pollLast();
		}
		return deque;
	}
}
