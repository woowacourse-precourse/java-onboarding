package onboarding;

public class Problem2 {
	private static final int CHECK_INIT = 0;

	public static String solution(String cryptogram) {
		String answer = cryptogram;
		return answer;
	}

	public static String removeString(String answer) {
		char checkChar = answer.charAt(CHECK_INIT);
		StringBuilder removeString = new StringBuilder();
		for (int i = 1; i < answer.length(); i++) {
			if (answer.charAt(i) != checkChar) {
				removeString.append(answer.charAt(i));
			}
		}
        return removeString.toString();
	}

}
