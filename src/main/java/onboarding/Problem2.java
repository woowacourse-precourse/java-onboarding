package onboarding;

public class Problem2 {
	private static final int CHECK_INIT = 0;

	public static String solution(String cryptogram) {
		String answer = cryptogram;
		int answerLength;
		do {
			answerLength = answer.length();
			answer = removeString(answer);

		} while(answerLength != answer.length() && answer.length()!=0);

		return answer;
	}

	private static String removeString(String answer) {
		StringBuilder plainIndex = new StringBuilder();
		char checkText = answer.charAt(CHECK_INIT);
		for(int i =1; i<answer.length(); i++) {
			if(checkText != answer.charAt(i)) {
				checkText = answer.charAt(i);
				plainIndex.append(answer.charAt(i-1));
			} else {
				while(i<answer.length() && checkText == answer.charAt(i)){
					i++;
				}
			}
		}
		if(plainIndex.toString().length()>0) {
			return plainIndex.append(answer.charAt(answer.length() - 1)).toString();
		}
		return plainIndex.toString();
	}

}
