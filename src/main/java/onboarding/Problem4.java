package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		answer = word;
		answer = changeSmallLetters(answer);
		answer = changeCapitalLetters(answer);
		return answer;
	}
	
	public static String changeSmallLetters(String word) {
		StringBuilder changeWord = new StringBuilder(word);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
				char change = (char) ('a' + 'z' - word.charAt(i));
				changeWord.setCharAt(i, change);
			}
		}
		return changeWord.toString();
	}
	public static String changeCapitalLetters(String word) {
		StringBuilder changeWord = new StringBuilder(word);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				char change = (char) ('A' + 'Z' - word.charAt(i));
				changeWord.setCharAt(i, change);
			}
		}
		return changeWord.toString();
	}
}
