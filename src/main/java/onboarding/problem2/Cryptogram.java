package onboarding.problem2;

import java.util.Stack;

public class Cryptogram {
	private Cryptogram() {

	}

	public static String getRightAnswer(String cryptogram) {
		Stack<Character> resultList = new Stack<>();
		char[] cryptogramChars = cryptogram.toCharArray();
		int n = cryptogramChars.length;
		int index = 0;
		while (index < n) {
			if (resultList.isEmpty()) {
				resultList.add(cryptogramChars[index]);
				index++;
			} else if (resultList.peek().equals(cryptogramChars[index])) {
				Character c = resultList.pop();
				index++;
				while (index < n && c.equals(cryptogramChars[index])) {
					index++;
				}
			} else {
				resultList.add(cryptogramChars[index]);
				index++;
			}
		}
		String answer = "";
		while (!resultList.isEmpty()) {
			answer = String.format("%s%s", resultList.pop(), answer);
		}
		return answer;
	}
}
