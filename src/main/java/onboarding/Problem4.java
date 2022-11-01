package onboarding;

public class Problem4 {
	public static String solution(String word) {
		char[] wordList = word.toCharArray();
		int idx = 0;

		for (int ascii : wordList) {
			if (65 <= ascii && ascii <= 90) {
				wordList[idx++] = (char)((char)25 - (ascii - 65) + 65);
				continue;
			}
			if (97 <= ascii && ascii <= 122) {
				wordList[idx++] = (char)((char)25 - (ascii - 97) + 97);
				continue;
			}
			wordList[idx++] = (char)ascii;
		}
		return String.valueOf(wordList);
	}
}
