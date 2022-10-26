package onboarding;

public class Problem2 {

	private static String toEliminateDuplicate(String givenString) {
		StringBuilder eliminateDuplicateString = new StringBuilder();
		char compareString = givenString.charAt(0);
		int isDuplicated = 0;

		for (int i = 1; i < givenString.length(); i++) {
			if (givenString.charAt(i) != compareString) {
				if (isDuplicated == 0) {
					compareString = givenString.charAt(i);
					eliminateDuplicateString.append(compareString);
				} else {
					isDuplicated = 0;
					continue;
				}
			} else if (givenString.charAt(i) == compareString) {
				isDuplicated = 1;
			}
		}
		if (isDuplicated == 0) {
			eliminateDuplicateString.append(compareString);
		}

		return eliminateDuplicateString.toString();
	}

	public static String solution(String cryptogram) {
		String answer = "answer";
		return answer;
	}
}
