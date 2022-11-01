package onboarding;

public class Problem4 {
	// 규칙에 따라 글자마다 반대글자를 출력한다.
	public static String solution(String word) {
		return getReversedWord(word);
	}

	// 기능1. 문자열의 글자마다 반대글자를 찾아서 반대 문자열을 완성시킨다.
	private static String getReversedWord(String word) {
		String processing = "";
		// 문자열의 글자를 하나씩 가져온다.
		for (char elem : word.toCharArray()) {
			if (isCapital(elem) == -1) {
				// 대소문자 이외의 문자면 변환없이 저장한다.
				processing += elem;
				continue;
			}
			// 대소문자라면 반대글자로 변환해서 저장한다.
			processing += reverseCharacter(elem, isCapital(elem));
		}

		return processing;
	}

	// 기능 2. 규칙에 따라 하나의 글자를 반대글자로 변환시켜 출력한다.
	private static char reverseCharacter(char original, int UpperOrLower) {
		char reversed;
		// UpperOrLower는 대문자일 경우 64, 소문자일 경우 96이다.
		int baseASCII = 25 - 2 * (((int) original - UpperOrLower) - 1);
		if (baseASCII < 0) {
			// baseASCII가 음수일 때는 origin과 빼서 계산한다.
			reversed = (char) ((int) original - baseASCII);
		}
		// baseASCII가 양수일 때는 origin과 더해서 계산한다.
		reversed = (char) ((int) original + baseASCII);
		// 반대글자를 출력한다.
		return reversed;
	}

	// 기능 3. 글자가 대문자인지 소문자인지 예외글자인지 파악한다.
	private static int isCapital(char elem) {
		if (Character.isUpperCase(elem)) {
			// 대문자인 경우
			return 64;
		} else if (Character.isLowerCase(elem)) {
			// 소문자인 경우
			return 96;
		}
		// 예외글자인 경우
		return -1;
	}


}
