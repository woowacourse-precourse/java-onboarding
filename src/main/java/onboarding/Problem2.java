package onboarding;

import java.util.Stack;

public class Problem2 {
	public static String solution(String cryptogram) {

		// 해독할때까지 재귀
		return decryptionRecursion(cryptogram);
	}

	static String decryptionRecursion(String cryptogram) {
		// 문자열을 배열로 변환
		char[] chars = cryptogram.toCharArray();
		// 배열의 길이 및 인접 중복 문자열 존재 여부 확인
		if (isLengthEnough(chars) || !isDuplicate(chars)) {
			return cryptogram;
		}

		// 인접한 중복 문자열 제거
		Stack<Character> decryptionStack = removeDuplicates(chars);
		// stack을 문자열로 변환
		String answer = stackToString(decryptionStack);
		return decryptionRecursion(answer);
	}

	static String stackToString(Stack<Character> stack) {
		StringBuilder stringBuilder = new StringBuilder();

		for (char c : stack) {
			stringBuilder.append(c);
		}

		return stringBuilder.toString();
	}

	static Stack<Character> removeDuplicates(char[] chars) {

		char prev = 0;
		Stack<Character> stack = new Stack<>();

		for (char c : chars) {
			if (prev != c) {
				stack.push(c);
				prev = c;
			} else {
				stack.pop();
			}
		}
		return stack;
	}

	static boolean isDuplicate(char[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				return true;
			}
		}
		return false;
	}

	static boolean isLengthEnough(char[] arr) {
		return arr.length < 2;
	}
}
