package onboarding;

public class Problem4 {

	public static final int ASCII_A = 65;
	public static final int ASCII_Z = 90;
	public static final int ASCII_a = 97;
	public static final int ASCII_z = 122;

	public static String solution(String word) {
		char[] wordArray = word.toCharArray();
		reverseWord(wordArray);
		return new String(wordArray);
	}

	private static void reverseWord(char[] wordArray) {
		int asciiNum;
		int reverseAsciiNum;
		int distanceOfWord;
		for (int i = 0; i < wordArray.length; i++) {
			asciiNum = (int)wordArray[i];
			if (asciiNum >= ASCII_A && asciiNum <= ASCII_Z) {
				distanceOfWord = asciiNum - ASCII_A;
				reverseAsciiNum = ASCII_Z - distanceOfWord;
				wordArray[i] = (char)reverseAsciiNum;
			}
			if (asciiNum >= ASCII_a && asciiNum <= ASCII_z) {
				distanceOfWord = asciiNum - ASCII_a;
				reverseAsciiNum = ASCII_z - distanceOfWord;
				wordArray[i] = (char)reverseAsciiNum;
			}
		}
	}
}
