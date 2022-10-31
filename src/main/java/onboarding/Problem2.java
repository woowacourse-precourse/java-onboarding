package onboarding;

import java.util.Stack;

/**
 * Problem2 기능 목록
 * 1. 문자를 배열로 변환하기
 * 2. 배열의 길이와 중복 문자열 존재 여부를 확인하여 연속하는 중복 문자들이 없다면 리턴하기
 * 3. 중복 문자열이 있다면 중복문자열을 제거한 후 스택에 담기
 * 4. 스택을 문자열로 변환하기
 * 5. 변환된 문자열을 재귀함수로 해독하기
 */
public class Problem2 {
	public static String solution(String cryptogram) {

		// 문자열을 배열로 변환
		char[] chars = cryptogram.toCharArray();
		// 배열의 길이 및 인접 중복 문자열 존재 여부 확인
		if (isLengthEnough(chars) || !isDuplicate(chars)) {
			return cryptogram;
		}

		// 인접한 중복 문자열 제거
		Stack<Character> decryptionStack = removeDuplicates(chars);
		// stack 문자열로 변환
		String answer = stackToString(decryptionStack);
		// 해독할때까지 재귀
		return solution(answer);
	}

	private static String stackToString(Stack<Character> stack) {
		StringBuilder stringBuilder = new StringBuilder();

		for (char c : stack) {
			stringBuilder.append(c);
		}

		return stringBuilder.toString();
	}

	private static Stack<Character> removeDuplicates(char[] chars) {

		char prev = 0;
		Stack<Character> stack = new Stack<>();

		for (char c : chars) {
			prev = getRemoveDuplicateStack(prev, stack, c);
		}
		return stack;
	}

	private static char getRemoveDuplicateStack(char prev, Stack<Character> stack, char c) {
		if (prev != c) {
			stack.push(c);
			prev = c;
		} else if (isRemovable(stack, prev)) {
			stack.pop();
		}
		return prev;
	}

	private static boolean isRemovable(Stack<Character> stack, char prev) {
		return !stack.empty() && prev == stack.peek();
	}

	private static boolean isDuplicate(char[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				return true;
			}
		}
		return false;
	}

	private static boolean isLengthEnough(char[] arr) {
		return arr.length < 2;
	}

}
