package onboarding;

import java.util.HashMap;

public class Problem4 {
	private static HashMap<Character,Character> frogDic = new HashMap<>();
	private static final char LOWER_FIRST_CHAR='a';
	private static final char LOWER_MIDDLE_CHAR='m';
	private static final char LOWER_END_CHAR='z';
	private static final char UPPER_FIRST_CHAR='A';
	private static final char UPPER_MIDDLE_CHAR='M';
	private static final char UPPER_END_CHAR='Z';

	public static String solution(String word) {
		initFrogDic();
		String answer = "";
		return answer;
	}

	private static void initFrogDic(){
		for(char ch = UPPER_FIRST_CHAR; ch<=UPPER_END_CHAR; ch++)
			frogDic.put(ch,(char)(2*UPPER_MIDDLE_CHAR-ch+1));
		for(char ch = LOWER_FIRST_CHAR; ch<=LOWER_END_CHAR; ch++)
			frogDic.put(ch,(char)(2*LOWER_MIDDLE_CHAR-ch+1));
	}
}
