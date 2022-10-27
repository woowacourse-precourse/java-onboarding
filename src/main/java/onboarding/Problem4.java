package onboarding;

public class Problem4 {
	static final String[] UPPER_CASE_ARR = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L",
		"K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
	static final String[] LOWER_CASE_ARR = {"z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l",
		"k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a"};

	public static String solution(String word) {

		//문자열을 배열로 변환
		char[] arr = word.toCharArray();
		String answer = "";
		return answer;
	}

	static int charToIndex(char j) {
		//문자를 인덱스 숫자로 변환
		return (int)j >= 97 ? j - 97 : j - 65;
	}

}
