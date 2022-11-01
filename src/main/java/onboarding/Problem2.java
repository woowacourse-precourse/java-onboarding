package onboarding;

import java.util.Arrays;

public class Problem2 {

	static char[] chars;
	static Boolean[] removedIndex;
	static int lengthOfString;
	static int nowRemoved;

	public static String solution(String cryptogram) {
		Boolean isChanged;
		nowRemoved = 0;
		chars = cryptogram.toCharArray();
		lengthOfString = chars.length;
		removedIndex = new Boolean[lengthOfString];
		Arrays.fill(removedIndex, Boolean.FALSE);

		do {
			isChanged = false;
			int before = -1;

			for (int i = 0; i < lengthOfString; i++) {
				if (removedIndex[i]) {
					continue;
				}

				if (before == -1 || chars[before] != chars[i]) {
					before = i;
					continue;
				}

				isChanged = true;
				executeChange(before);
				executeChange(i);
			}
		} while (isChanged);

		return getCurrentString();
	}

	private static void executeChange(int i) {
		if (!removedIndex[i]) {
			removedIndex[i] = true;
			nowRemoved += 1;
		}
	}

	private static String getCurrentString() {
		String answer = "";
		for (int i = 0; i < lengthOfString; i++) {
			if (!removedIndex[i]) {
				answer += chars[i];
			}
		}
		return answer;
	}
}
