package onboarding;

import onboarding.validatechecker.Problem2ValidateChecker;

public class Problem2 {
	private static boolean duplicateFlag;

	public static String solution(String cryptogram) {
		Problem2ValidateChecker.isCryptogramValidate(cryptogram);
		String answer = cryptogram;
		duplicateFlag=true;

		while(duplicateFlag) {
			answer = removeDuplicateCharacter(answer);
		}

		return answer;
	}

	public static String removeDuplicateCharacter(String str){
		duplicateFlag=false;
		char[] charArray = str.toCharArray();
		String result = "";
		char preChar = '\0';

		for (char ch : charArray) {
			if(ch != preChar)
				result += ch;
			else {
				duplicateFlag = true;
				result=result.substring(0,result.length()-1);
			}
			preChar=ch;
		}
		return result;
	}
}
