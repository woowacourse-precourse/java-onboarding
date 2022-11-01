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
		return getCurrentString();
	}

	private static String getCurrentString() {
		String answer = "";
		for (int i = 0; i < lengthOfString; i++) {
			if (!removeIndex[i]) {
				answer += chars[i];
			}
		}
		return answer;
	}
}
