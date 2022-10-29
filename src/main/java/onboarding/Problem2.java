package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = cryptogram;
		while (removeDuplicate(answer).compareTo(answer) != 0) {
			answer = removeDuplicate(answer);
		}
		return answer;
	}

	private static String removeDuplicate(String givenString) {
		StringBuilder removedString = new StringBuilder();
		char lastLetter = '\0';
		boolean isDuplicated = true;

		for (char nowLetter : givenString.toCharArray()) {
			if (nowLetter != lastLetter) {
				if (isDuplicated) {
					lastLetter = nowLetter;
					isDuplicated = false;
				} else {
					removedString.append(lastLetter);
					lastLetter = nowLetter;
				}
			} else if (nowLetter == lastLetter) {
				isDuplicated = true;
			}
		}
		if (!isDuplicated) {
			removedString.append(lastLetter);
		}
		return removedString.toString();
	}
}
