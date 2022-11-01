package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	public static String solution(String cryptogram) {
		// 해독한 암호를 결과로 출력한다.
		return decrypt(cryptogram);
	}

	// 기능1. 암호해독을 한다.
	private static String decrypt(String cryptogram) {
		List<String> duplicatedLetters;
		String decryption;

		while (true) {
			// cryptogram에 있는 중복문자열을 리스트로 받는다.
			duplicatedLetters = findLetters(cryptogram);

			if (isDone(duplicatedLetters)) {
				//duplicatedLetters에 어떠한 값도 없다면 모두 해독한 것이다.
				break;
			}
			// 중복문자열을 제거한 문자열을 cryptogram에 넣는다.
			cryptogram = removeDuplicatedLetters(cryptogram, duplicatedLetters);
		}

		// 모두 해독된 문자열을 결과로 출력한다.
		decryption = cryptogram;
		return decryption;
	}

	// 기능 3. 중복문자열을 찾아낸다.
	private static List<String> findLetters(String cryptogram) {
		List<String> duplicatedLetters = new ArrayList<>();
		// 문자열을 가리키는 두 개의 포인터를 이용해 중복검사를 한다.
		int startIdx = 0, endIdx = 1;
		int duplicatedLength = 1;

		int cryptogramLength = cryptogram.length();
		// startIdx는 문자열의 문자를 처음부터 끝까지 순회한다.
		while (startIdx < cryptogramLength) {
			// 만일 endIdx가 cryptogram의 length범위를 넘어갈 때
			if (endIdx >= cryptogramLength) {
				// 중복문자열이 존재하고, 그 문자열 길이가 2이상이면
				if (cryptogram.charAt(startIdx) == cryptogram.charAt(endIdx - 1)
					&& duplicatedLength > 1) {
					String duplicatedLetter =
						getLetter(duplicatedLength, cryptogram.charAt(startIdx));
					// duplicatedLetters에 중복문자열을 저장한다.
					duplicatedLetters.add(duplicatedLetter);
				}
				break;
			}
			// startIdx와 endIdx가 가리키는 글자가 다른 글자라면
			if (cryptogram.charAt(startIdx) != cryptogram.charAt(endIdx)) {
				// 중복문자열을 찾다가 다른 문자를 가리키게 되는 경우
				if (duplicatedLength > 1) {
					// 이때 중복문자열 길이가 2이상이면
					String duplicatedLetter =
						getLetter(duplicatedLength, cryptogram.charAt(startIdx));
					// duplicatedLetters에 중복문자열을 저장한다.
					duplicatedLetters.add(duplicatedLetter);
				}
				// 중복문자를 못 찾는 경우, startIdx와 endIdx를 이동시킨다.
				duplicatedLength = 1;
				startIdx = endIdx;
				endIdx = startIdx + 1;
				continue;
			}
			// 중복문자를 찾은 경우 endIdx와 duplicatedLength의 길이를 늘린다.
			duplicatedLength++;
			endIdx++;
		}
		// 찾아낸 중복문자열 리스트를 반환한다.
		return duplicatedLetters;
	}

	// 기능 4. 중복문자열 리스트가 가진 문자열을 암호문에서 제거한다.
	private static String removeDuplicatedLetters(String cryptogram,
		List<String> duplicatedLetters) {
		for (String letters : duplicatedLetters) {
			// duplicatedLetters가 가진 문자열을 replaceFirst로 제거한다.
			String tmp = cryptogram.replaceFirst(letters, "");
			cryptogram = tmp;
		}
		// 제거된 문자열을 반환한다.
		return cryptogram;
	}

	// 기능 2. 암호해독이 모두 끝났는지 확인한다.
	private static boolean isDone(List<String> duplicatedLetters) {
		// 만일 duplicatedLetters가 비어있으면 해독이 모두 끝난 것이다.
		if (duplicatedLetters.isEmpty()) {
			return true;
		}
		return false;
	}

	// 기능 3-1. 찾아낸 중복문자의 길이만큼 문자열을 만들어낸다.
	private static String getLetter(int length, char charAt) {
		String letter = "";
		while (length != 0) {
			letter += charAt;
			length--;
		}
		return letter;
	}
}
