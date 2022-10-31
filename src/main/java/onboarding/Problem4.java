package onboarding;

public class Problem4 {

	// 입력받은 문자열을 반대로 변환하는 메소드
	public static String solution(String word) {
		StringBuilder sb = new StringBuilder();
		String answer;

		for (int i = 0; i < word.length(); i++) {
			char c = reverse(word.charAt(i));
			sb.append(c);
		}

		answer = sb.toString();

		return answer;
	}

	// 알파벳을 반대로 변환하는 메소드
	private static char reverse(char c) {
		char reverseUpper = (char)('A' + 'Z' - c);
		char reverseLower = (char)('a' + 'z' - c);

		if (Character.isUpperCase(c)) {
			return reverseUpper;
		}

		if (Character.isLowerCase(c)) {
			return reverseLower;
		}

		return c;
	}

}
