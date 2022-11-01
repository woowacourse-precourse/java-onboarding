package onboarding;

import java.util.Stack;

public class Problem2 {

	public static final String ERROR_MESSAGE = "제한 사항을 위배했습니다.";
	public static final int EXCEPTION = -1;

	public static String solution(String cryptogram) {
		Stack<Character> decodedCryptogram;

		if (checkRestrictions(cryptogram) == EXCEPTION) {
			return ERROR_MESSAGE;
		}

		decodedCryptogram = removeDuplicateCharacters(cryptogram);

		return stackToString(decodedCryptogram);
	}

	private static Stack<Character> removeDuplicateCharacters(String cryptogram) {
		Stack<Character> decodedCryptogram = new Stack<Character>();
		char duplicateCharacter = ' ';
		char top = ' ';
		char current = ' ';
		for (int i = 0; i < cryptogram.length(); i++) {
			current = cryptogram.charAt(i);

			if (decodedCryptogram.isEmpty()) {
				decodedCryptogram.push(current);
				continue;
			}
			top = decodedCryptogram.peek();
			if (current != top && current != duplicateCharacter) {
				decodedCryptogram.push(current);
				duplicateCharacter = ' ';
			}
			if (current == top) {
				duplicateCharacter = top;
				decodedCryptogram.pop();
			}
		}
		return decodedCryptogram;
	}

	private static Integer checkRestrictions(String cryptogram) {
		if (!isCryptogramSizeValid(cryptogram)) {
			return EXCEPTION;
		}
		if (!isCryptogramLowerCase(cryptogram)) {
			return EXCEPTION;
		}
		return 0;
	}

	private static boolean isCryptogramSizeValid(String cryptogram) {
		if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
			return false;
		}
		return true;
	}

	private static boolean isCryptogramLowerCase(String cryptogram) {
		if (!cryptogram.equals(cryptogram.toLowerCase())) {
			return false;
		}
		return true;
	}

	private static String stackToString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		for (Character character : stack) {
			sb.append(character);
		}
		return sb.toString();
	}

}
