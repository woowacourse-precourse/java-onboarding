package onboarding;

public class Problem4 {
	public static String solution(String word) {
		char[] charArr = new char[word.length()];
		int tmp = 0; // 아스키코드 표 기준 앞에서부터 몇 번째 캐릭터인지
		char ch = ' ';

		for (int i = 0; i < word.length(); i++) {
			ch = word.charAt(i);
			if (ch > 'a' && ch < 'z') {
				tmp = ch - 96;
				charArr[i] = (char)(123 - tmp); // 뒤에서부터 tmp 번째 캐릭터를 대입
			} else if (ch > 'A' && ch < 'Z') {
				tmp = ch - 64;
				charArr[i] = (char)(91 - tmp);
			} else {
				charArr[i] = ch;
			}
		}

		return new String(charArr);
	}
}
