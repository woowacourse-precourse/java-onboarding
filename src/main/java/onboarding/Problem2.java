package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

	/**
	 * 기능 목록 작성
	 * 1. 문자열의 길이가 1일때 바로 리턴해주는 기능
	 * 2. 중복문자를 제거하는 기능(중복이 2개 이상일 경우도 처리)
	 * 3. 데큐에 남은 문자 문자열로 만드는 기능
	 */
	public static String solution(String cryptogram) {
		if (cryptogram.length() == 1) {
			return cryptogram;
		}

		return getAnswerString(removeDuplicationCharacter(cryptogram));
	}

	private static Deque<Character> removeDuplicationCharacter(String cryptogram) {
		Deque<Character> deque = new ArrayDeque<>();
		char duplicationChar = ' ';
		for (int i = 0; i < cryptogram.length(); i++) {
			if (duplicationChar == cryptogram.charAt(i)) {
				continue;
			}
			if (!deque.isEmpty() && deque.peekLast() == cryptogram.charAt(i)) {
				duplicationChar = deque.pollLast();
				continue;
			}
			deque.offer(cryptogram.charAt(i));
			duplicationChar = ' ';
		}
		return deque;
	}

	private static String getAnswerString(Deque<Character> deque) {
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			sb.append(deque.pollFirst());
		}

		return sb.toString();
	}

}
