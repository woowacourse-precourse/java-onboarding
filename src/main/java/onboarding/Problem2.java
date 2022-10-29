package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";
		String removedAnswer;
		answer = cryptogram;
		while (true) {
			removedAnswer = removeDuplicateLetters(answer);
			if (answer.equals(removedAnswer)) {
				break;
			}
			answer = removedAnswer;
		}
		return answer;
	}
	public static String removeDuplicateLetters(String str) {
		String removedStr = str;
		for (char i = 'a'; i <= 'z'; i++) {
			removedStr = removedStr.replaceAll(i + "{2,}", " ");
		}
		removedStr = removedStr.replaceAll(" ", "");
		return removedStr;
	}
}
