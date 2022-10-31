package onboarding;

/**
 * Problem4 기능 목록
 * 1. 대문자용 변환 문자 배열 및 소문자용 변환 문자 배열 생성
 * 2. 입력된 문자열을 배열로 변환
 * 3. 배열 안의 문자를 변환 후 stringBuiler에 더해주기
 * 4. stringBuilder를 String으로 변환 후 리턴하기
 */
public class Problem4 {
	private static final String[] UPPER_CASE_ARR = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N",
		"M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
	private static final String[] LOWER_CASE_ARR = {"z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n",
		"m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a"};

	public static String solution(String word) {

		//문자열을 배열로 변환
		char[] arr = word.toCharArray();

		StringBuilder stringBuilder = new StringBuilder();

		for (char j : arr) {
			//문자 변환
			String result = changeWord(j);
			//변환된 문자 stringBuilder 더해주기
			stringBuilder.append(result);
		}
		return stringBuilder.toString();
	}

	private static String changeWord(char j) {
		//대소문자 여부 판별
		if (Character.isUpperCase(j)) {
			//아스키코드를 반대문자로 변환
			return UPPER_CASE_ARR[charToIndex(j)];
		} else if (Character.isLowerCase(j)) {
			//아스키코드를 반대문자로 변환
			return LOWER_CASE_ARR[charToIndex(j)];
		}
		return String.valueOf(j);
	}

	private static int charToIndex(char j) {
		//문자를 인덱스 숫자로 변환
		return (int)j >= 97 ? j - 97 : j - 65;
	}

}
