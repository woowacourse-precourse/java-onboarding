package onboarding;

import java.util.List;
import java.util.Arrays;
// import java.util.Collections;

public class Problem4 {
	public static void main(String[] args) {

		char[] UPPERCASE = createAlphabetArr('A');
		char[] LOWERCASE = createAlphabetArr('a');

		char[] reverseUppercase = (reverseNewArr(UPPERCASE));
		char[] reverseLowercase = (reverseNewArr(LOWERCASE));

		System.out.println(UPPERCASE);
		System.out.println(LOWERCASE);

	}

	// ㅜ 알파벳 배열을 만드는 함수
	public static char[] createAlphabetArr(char a) {

		char[] alphabetArr = new char[26];

		for (int i = 0; i < alphabetArr.length; i++) {

			alphabetArr[i] = (char) (a + i);
		}

		return alphabetArr;
	}

	// ㅜ 배열을 뒤집어서 반환하는 함수
	public static char[] reverseNewArr(char[] arr) {

		// ㅜ Type mismatch
		// ㅜ Character 타입과 char[] 타입이 왜 다른 걸까...
		// List<Character> reverse = Arrays.asList(arr);

		// ㅜ 배열을 리스트로 변환
		List<char[]> list = Arrays.asList(arr);

		// ㅜ [[C@1eb44e46]
		// System.out.println(list);

		// ㅜ 1
		// System.out.println(list.size());

		// ㅜ 인자로 전달된 리스트의 요소 순서를 뒤집는 함수
		// Collections.reverse(list);

		// ㅜ [[C@1eb44e46]
		// System.out.println(list);

		char[] reverseArr = new char[26];

		for (int i = 0; i < arr.length; i++) {

			int idx = arr.length - 1 - i;

			reverseArr[i] = list.get(0)[idx];
		}
		// ㅜ 정방향
		// System.out.println(list.get(0));
		// System.out.println(arr);

		return reverseArr;
	}

	public static String solution(String word) {
		String answer = "";
		return answer;
	}
}