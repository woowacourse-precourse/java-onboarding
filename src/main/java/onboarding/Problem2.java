package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * ex.     bannonnoa
 *      			      | stack[]
 * i: 0...2	stack.push()  | stack[b, a, n]
 * i: 3     stack.pop()   | stack[b, a]
 * i: 4     stack.push()  | stack[b, a, o]
 * i: ...
 */

public class Problem2 {
	private static Stack<Character> decryptionStack;
	public static String solution(String cryptogram) {
		decryptionStack = new Stack<>();
		int cursor = 0;
		while (cursor < cryptogram.length()) {
			int afterVisit = visitCharAt(cryptogram, cursor);
			cursor = afterVisit;
		}

		return covertCharacterStackToString(decryptionStack);
	}

	private static int visitCharAt(String cryptogram, int cursor) {
		char visitLetter = cryptogram.charAt(cursor);
		if (addable(visitLetter)) {
			decryptionStack.add(visitLetter);
			return cursor + 1;
		}

		return isDuplicateLetter(cryptogram, cursor);
	}

	private static boolean addable(char letter) {
		if (decryptionStack.empty()) {
			return true;
		}

		if (decryptionStack.peek() != letter) {
			return true;
		}
		return false;
	}

	private static int isDuplicateLetter(String cryptogram, int cursor) {
		Character lastLetter = decryptionStack.peek();
		while (cursor < cryptogram.length()
			&& cryptogram.charAt(cursor) == lastLetter) {
			cursor += 1;
		}

		decryptionStack.pop();
		return cursor;
	}

	private static String covertCharacterStackToString(Stack<Character> stack) {
		return stack.stream()
			.map(String::valueOf)
			.collect(Collectors.joining());
	}
}
