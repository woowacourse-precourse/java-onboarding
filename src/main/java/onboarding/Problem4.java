package onboarding;

public class Problem4 {

	public static String solution(String word) {
		String answer = "";

		answer = translateString(word);

		return answer;
	}

	/**
	 * 기능 1 String을 청개구리 사전으로 변환 하는 기능
	 */

	public static String translateString(String word) {
		String translatedString = "";  // 변환된 문자를 추가할 문자열

		for (int i = 0; i < word.length(); i++) {
			if (checkAlphabet(word.charAt(i))) { // 변환할 문자열이 알파벳이 맞는지 검증
				translatedString += translateChar(word.charAt(i));
			}
			if (!checkAlphabet(word.charAt(i))) { // 알파벳이 아니면
				translatedString += word.charAt(i);
			}
		}

		return translatedString;
	}

	/**
	 * 기능 2 알파벳인지 아닌지를 구분하는 기능
	 */
	public static boolean checkAlphabet(char ch) {

		if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) { // 아스키 코드에서 65~90은 대문자, 97~122가 소문자
			return true;
		}

		return false;
	}

	/**
	 * 기능 3 알파벳 하나를 변환 하는 기능
	 * 'A' + 25 = 'Z' , 'Z' - 25 = 'A'
	 * 따라서 청개구리 변환 공식은 parameter + (25 - '알파벳의 순서 값' * 2)
	 */
	public static char translateChar(char ch) {
		char translatedCharacter = ' ';

		if (checkUpperOrLower(ch)) // 대문자 인 경우
		{
			int add = ch - 'A'; // 몇번째 알파벳인지 구한 값
			translatedCharacter = (char) (ch + (25 - add * 2));
			return translatedCharacter;
		}
		int add = ch - 'a';
		translatedCharacter = (char) (ch + (25 - add * 2));

		return translatedCharacter;
	}

	/**
	 * 기능 4 알파벳 대문자 소문자 구분 하는 기능 true : 대문자 , false : 소문자
	 */
	public static boolean checkUpperOrLower(char ch) {
		if (ch >= 65 && ch <= 90) // 대문자일 경우,
		{
			return true;
		}

		return false;
	}

}
