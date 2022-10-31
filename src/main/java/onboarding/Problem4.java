package onboarding;

import java.util.HashMap;

import onboarding.validatechecker.Problem4ValidateChecker;

public class Problem4 {
	private static final char LOWER_FIRST_CHAR='a';
	private static final char LOWER_MIDDLE_CHAR='m';
	private static final char LOWER_END_CHAR='z';
	private static final char UPPER_FIRST_CHAR='A';
	private static final char UPPER_MIDDLE_CHAR='M';
	private static final char UPPER_END_CHAR='Z';

	public static String solution(String word) {
		Problem4ValidateChecker.isWordValidate(word);
		return translateWord(word);
	}

	private static String translateWord(String word) {
		HashMap<Character,Character> frogDic = generateFrogDic();
		StringBuilder answerBuilder = new StringBuilder();
		for (char key : word.toCharArray()) {
			if(!Character.isAlphabetic(key)){
				answerBuilder.append(key);
				continue;
			}
			answerBuilder.append(frogDic.get(key));
		}
		return answerBuilder.toString();
	}

	private static HashMap<Character,Character> generateFrogDic(){
		HashMap<Character,Character> frogDic = new HashMap<>();
		for(char ch = UPPER_FIRST_CHAR; ch<=UPPER_END_CHAR; ch++)
			frogDic.put(ch,(char)(2*UPPER_MIDDLE_CHAR-ch+1));
		for(char ch = LOWER_FIRST_CHAR; ch<=LOWER_END_CHAR; ch++)
			frogDic.put(ch,(char)(2*LOWER_MIDDLE_CHAR-ch+1));
		return frogDic;
	}
}
