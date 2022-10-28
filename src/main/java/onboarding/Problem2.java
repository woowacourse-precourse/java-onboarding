package onboarding;

import onboarding.validatechecker.Problem2ValidateChecker;

public class Problem2 {
	private static boolean duplicateFlag;
	private static final String EMPTY_CHAR=" ";

	public static String solution(String cryptogram) {
		Problem2ValidateChecker.isCryptogramValidate(cryptogram);
		String answer = cryptogram;
		duplicateFlag = true;

		while(duplicateFlag)
			answer = removeDuplicateCharacter(answer);

		return answer;
	}

	private static String removeDuplicateCharacter(String str){
		char[] charArray = str.toCharArray();
		StringBuilder resultBuilder = new StringBuilder();
		char preChar = '\0';
		duplicateFlag = false;

		for (char ch : charArray) {
			if(ch != preChar)
				resultBuilder.append(ch);
			else {
				duplicateFlag = true;
				resultBuilder.setLength(resultBuilder.length()-1);
				resultBuilder.append(EMPTY_CHAR);
			}
			preChar=ch;
		}

		return resultBuilder.toString().replaceAll(EMPTY_CHAR,"");
	}
}
