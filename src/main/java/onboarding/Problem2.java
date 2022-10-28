package onboarding;

import onboarding.validatechecker.Problem2ValidateChecker;

public class Problem2 {
	private static boolean duplicateFlag;

	public static String solution(String cryptogram) {
		Problem2ValidateChecker.isCryptogramValidate(cryptogram);
		String answer = cryptogram;
		duplicateFlag = true;

		while(duplicateFlag) {
			answer = removeDuplicateCharacter(answer);
		}

		return answer;
	}

	private static String removeDuplicateCharacter(String str){
		char[] charArray = str.toCharArray();
		StringBuilder resultBuilder = new StringBuilder();
		char preChar = '\0';
		boolean eraseFirstCharacterFlag=false;
		duplicateFlag = false;

		for (char ch : charArray) {
			if(ch != preChar) {
				if(eraseFirstCharacterFlag){
					resultBuilder.setLength(resultBuilder.length()-1);
					eraseFirstCharacterFlag=false;
				}
				resultBuilder.append(ch);
			}
			else {
				duplicateFlag = true;
				eraseFirstCharacterFlag = true;
			}
			preChar=ch;
		}

		if (eraseFirstCharacterFlag)
			resultBuilder.setLength(resultBuilder.length()-1);

		return resultBuilder.toString();
	}
}
