package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		if (!restrictions(word)) {
			answer = conversion(word);
		}
		return answer;
	}

	static boolean restrictions(String word) {
		if (!checkWordLength(word.length()) || !checkWordAlphabet(word)) {
			return true;
		}
		return false;
	}

	static boolean checkWordLength(int wordLen) {
		if (1 > wordLen || 1000 < wordLen) {
			return false;
		}
		return true;
	}

	static boolean checkWordAlphabet(String word) {
		String removeSpaceWord = word.replaceAll(" ", "");
		for (int i = 0; i < removeSpaceWord.length(); i++) {
			char c = removeSpaceWord.charAt(i);
			if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
				return false;
			}
		}
		return true;
	}

	static String conversion(String word) {
		String[] wordSplit = word.split("");
		String reverseWord = "";
		for (int i = 0; i < wordSplit.length; i++) {
			if (wordSplit[i].equals(" ")) {
				reverseWord += " ";
			} else {
				reverseWord += oneLetterConversion(wordSplit[i].charAt(0));
			}
		}
		return reverseWord;

	}

	static String oneLetterConversion(char oneChar) {
		String reverseChar = "";
		if (letterCaseCheck(oneChar)) {
			reverseChar += reverse(oneChar, 65);
		} else {
			reverseChar += reverse(oneChar, 97);
		}
		return reverseChar;

	}

	static boolean letterCaseCheck(char oneChar) {
		if (Character.isUpperCase(oneChar)) {
			return true;
		}
		return false;
	}

	static String reverse(char oneChar, int aASCII) {
		int reverseASCII = (aASCII + 25) - ((int) oneChar - aASCII);
		char reverseChar = (char) reverseASCII;
		return Character.toString(reverseChar);
	}
	
}
