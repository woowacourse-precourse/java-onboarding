package onboarding;

public class Problem2 {

	private static String toEliminateDuplicate(String givenString) {
		StringBuilder eliminateDuplicateString = new StringBuilder();
		char compareString = givenString.charAt(0);
		int isDuplicated = 0;

		for (int i = 1; i < givenString.length(); i++) {
			if (givenString.charAt(i) != compareString) {
				if (isDuplicated == 0) {
					eliminateDuplicateString.append(compareString);
					compareString = givenString.charAt(i);
				} else {
					isDuplicated = 0;
					continue;
				}
			} else if (givenString.charAt(i) == compareString) {
				continue;
			}
		}
		if (isDuplicated == 0) {
			eliminateDuplicateString.append(compareString);
		}
		System.out.println(eliminateDuplicateString);
		return eliminateDuplicateString.toString();
	}

	public static String solution(String cryptogram) {
		String answer = "answer";
		while (toEliminateDuplicate(cryptogram).compareTo(cryptogram) != 0) {
			cryptogram = toEliminateDuplicate(cryptogram);
		}
		answer = cryptogram;
		return answer;
	}
}
