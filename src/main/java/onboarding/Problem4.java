package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";

		// 먼저 String을 하나하나 char로 바꿔준다.
		char[] chars = word.toCharArray();

		// char 하나하나 만큼 반복하여
		for (int i = 0; i < chars.length; i++) {
			// 공백이면 공백을 리턴
			if (chars[i] == ' ') {
				answer += ' ';
			}
			// 대문자는 대문자 (아스키 코드)
			if (Character.isUpperCase(chars[i])) {
				answer += (char)(155 - (int)chars[i]);
			}
			// 소문자는 소문자 (아스키 코드)
			if (Character.isLowerCase(chars[i])) {
				answer += (char)(219 - (int)chars[i]);
			}
		}

		return answer;
	}
}
