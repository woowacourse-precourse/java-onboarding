package onboarding;

public class Problem4 {
	public static String solution(String word) {
		char[] charArr = new char[word.length()];
		int askiiSequence = 0; // 아스키코드 표 기준 앞에서부터 몇 번째 캐릭터인지
		char oneLetter = ' ';

		for (int i = 0; i < word.length(); i++) {
			oneLetter = word.charAt(i);
			if (oneLetter > 'a' && oneLetter < 'z') {
				askiiSequence = oneLetter - 96;
				charArr[i] = (char)(123 - askiiSequence); // 뒤에서부터 tmp 번째 캐릭터를 대입
			} else if (oneLetter > 'A' && oneLetter < 'Z') {
				askiiSequence = oneLetter - 64;
				charArr[i] = (char)(91 - askiiSequence);
			} else {
				charArr[i] = oneLetter;
			}
		}

		return new String(charArr);
	}
}
