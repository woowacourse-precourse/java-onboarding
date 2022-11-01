package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";

		// 아스키코드 십진법
		// 대문자 A 시작 65 Z 끝 90
		// 소문자 a 시작 97 z 끝 122
		answer = frogWord(word);

		return answer;
	}

	// 청개구리단어
	public static String frogWord(String word) {

		int len = word.length();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			char cur = word.charAt(i);

			char frogcur = doFrog(cur);
			sb.append(frogcur);
		}

		return sb.toString();
	}

	// 알파벳 바꿔 줌
	public static char doFrog(char cur) {
		// 알파벳 아니면 그대로 반환
		char changedChar = cur;
		int curType = typefind(cur);
		// 영어 대문자라면
		if (curType == 1) {
			// 90에서 현재 char값 빼고 그 값을 65에 더해주면 됨
			int curChar = cur + 0;

			int changedCharint = (90 - curChar) + 65;

			changedChar = (char) changedCharint;
		} else if (curType == -1) {
			// 122에서 현재 char값 빼고 그 값을 97에 더해주면 됨
			int curChar = cur + 0;

			int changedCharint = (122 - curChar) + 97;

			changedChar = (char) changedCharint;
		}

		return changedChar;
	}

	// 영어 대문자(1)인지 영어 소문자(-1)인지 아니면 알파벳이 아닌지 확인
	public static int typefind(char cur) {
		// 대문자 판단
		if (cur + 0 >= 65 && cur + 0 <= 90) {
			return 1;
		}
		// 소문자 판단
		if (cur + 0 >= 97 && cur + 0 <= 122) {
			return -1;
		}

		// 둘다 아니면 0
		return 0;
	}

}
