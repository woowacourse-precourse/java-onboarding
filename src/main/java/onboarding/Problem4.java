package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		return answer;
	}

	public static char changeChar(char c) {
		boolean isLowerCase = (c >= 'a');
		if (isLowerCase) {
			return (char)('a' + 'z' - c);
		}
		return (char)('A' + 'Z' - c);
	}
}
