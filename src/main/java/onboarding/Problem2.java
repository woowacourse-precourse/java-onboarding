package onboarding;

import java.util.Arrays;

public class Problem2 {

	static char[] chars;
	static Boolean[] removeIndex;
	static int lengthOfString;

	public static String solution(String cryptogram) {
		Boolean isChanged = false;
		chars = cryptogram.toCharArray();
		lengthOfString = chars.length;
		removeIndex = new Boolean[lengthOfString];
		Arrays.fill(removeIndex, Boolean.FALSE);
		int nowRemove = 0;
		String answer = "";
		return answer;
	}
}
