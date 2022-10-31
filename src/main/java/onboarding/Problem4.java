package onboarding;

public class Problem4 {
	public static final int PRE_a_IN_ASCII_TABLE = 96;
	public static final int NEXT_z_IN_ASCII_TABLE = 123;
	public static final int PRE_A_IN_ASCII_TABLE = 64;
	public static final int NEXT_Z_IN_ASCII_TABLE = 91;

	public static String solution(String word) {
		char[] charArr = new char[word.length()];
		int askiiSequence = 0; // 아스키코드 표 기준 앞에서부터 몇 번째 캐릭터인지
		char oneLetter = ' ';

		for (int i = 0; i < word.length(); i++) {
			oneLetter = word.charAt(i);
			if (oneLetter > 'a' && oneLetter < 'z') {
				askiiSequence = oneLetter - PRE_a_IN_ASCII_TABLE;
				charArr[i] = (char)(NEXT_z_IN_ASCII_TABLE - askiiSequence); // 뒤에서부터 tmp 번째 캐릭터를 대입
			} else if (oneLetter > 'A' && oneLetter < 'Z') {
				askiiSequence = oneLetter - PRE_A_IN_ASCII_TABLE;
				charArr[i] = (char)(NEXT_Z_IN_ASCII_TABLE - askiiSequence);
			} else {
				charArr[i] = oneLetter;
			}
		}

		return new String(charArr);
	}
}
