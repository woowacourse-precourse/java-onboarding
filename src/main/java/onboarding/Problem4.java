package onboarding;

public class Problem4 {
	public static String solution(String word) {
		char [] wordArray = word.toCharArray();
		reverseWord(wordArray);
		return new String(wordArray);
	}

	private static void reverseWord(char[] wordArray) {
		int asciiNum;
		int reverseAsciiNum;
		int distanceOfWord;
		for (int i = 0; i < wordArray.length; i++) {
			asciiNum = (int)wordArray[i];
			if (asciiNum >= 65 && asciiNum <= 90) {
				distanceOfWord = asciiNum - 65;
				reverseAsciiNum = 90 - distanceOfWord;
				wordArray[i] = (char) reverseAsciiNum;
			} 
			if (asciiNum >= 97 && asciiNum <= 122) {
				distanceOfWord = asciiNum - 97;
				reverseAsciiNum = 122 - distanceOfWord;
				wordArray[i] = (char) reverseAsciiNum;
			}
		}
	}
}
