package onboarding;

public class Problem4 {

	static char[] upperCaseList = new char[26];
	static char[] lowerCaseList = new char[26];

	public static String solution(String word) {
		String answer = "";

		for (int i = 0; i < 26; i++) {
			upperCaseList[i] = (char)(i + 65);
			lowerCaseList[i] = (char)(i + 97);
		}
		return reverseWord(word);

	}

	private static String reverseWord(String word) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char changedAlphabet = reverseAlphabet(word.charAt(i));
			stringBuilder.append(changedAlphabet);
		}
		return stringBuilder.toString();
	}

	private static char reverseAlphabet(char alphabet) {
		if (alphabet > 96 && alphabet < 123) {
			return reverseLowerCase(alphabet);
		}
		if (alphabet > 64 && alphabet < 91) {
			return reverseUpperCase(alphabet);
		}
		return alphabet;
	}

	private static char reverseUpperCase(char alphabet) {
		int index = alphabet - 'A';
		return upperCaseList[25 - index];
	}

	private static char reverseLowerCase(char alphabet) {
		int index = alphabet - 'a';
		return lowerCaseList[25 - index];
	}

}
