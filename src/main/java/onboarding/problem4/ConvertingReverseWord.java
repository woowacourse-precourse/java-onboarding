package onboarding.problem4;

public class ConvertingReverseWord {
	String convertedWord;

	public ConvertingReverseWord() {
		convertedWord = "";
	}

	// 기능1. 문자열을 입력 받아 처리를 하고 변경된 값을 return한다.
	public String process(String word) {
		char[] stringToChar = word.toCharArray();
		for (char elem : stringToChar) {
			int determination = isCapital(elem);
			if (determination == -1) {
				convertedWord += elem;
				continue;
			}
			convertedWord += reverse(elem, determination);
		}
		return convertedWord;
	}

	// 기능2. 입력 받은 문자열의 문자가 대문자인지 소문자인지 또는 예외문자인지 파악한다.
	public int isCapital(char elem) {
		if (elem >= 65 && elem <= 90) {
			// 대문자일 때
			return 1;
		} else if (elem >= 97 && elem <= 122) {
			// 소문자일 때
			return 0;
		}
		// 그외의 예외처리할 문자일 때
		return -1;
	}

	// 기능3. 대문자면 대문자 중 반대문자로 변환, 소문자면 소문자 중 반대문자로 변환을 한다.
	public char reverse(char elem, int determination) {
		char converted;

		if (determination == 1) {
			int convertBy = 25 - 2 * (((int) elem - 64) - 1);
			if (convertBy < 0) {
				converted = (char) ((int) elem - convertBy);
			}
			converted = (char) ((int) elem + convertBy);
			return converted;
		}

		int convertBy = 25 - 2 * (((int) elem - 96) - 1);
		if (convertBy < 0) {
			converted = (char) ((int) elem - convertBy);
		}
		converted = (char) ((int) elem + convertBy);
		return converted;

	}
}
