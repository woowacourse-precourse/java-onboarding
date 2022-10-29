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
		final char firstSmallLetter = 'a';
		final char lastSmallLetter = 'z';
		return changeLetters(word, firstSmallLetter, lastSmallLetter);
	}
	public static String changeCapitalLetters(String word) {
		final char firstCapitalLetter = 'A';
		final char lastCapitalLetter = 'Z';
		return changeLetters(word, firstCapitalLetter, lastCapitalLetter);
	}
	public static String changeLetters(String word, char first, char last) {
		StringBuilder changeWord = new StringBuilder(word);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= first && word.charAt(i) <= last) {
				char change = (char) (first + last - word.charAt(i));
				changeWord.setCharAt(i, change);
			}
		}
		return changeWord.toString();
	}
}
