package onboarding;

public class Problem2 {

	// 주어진 문자열의 연속하는 중복 문자를 제거하는 메소드
	public static String solution(String cryptogram) {
		String answer;

		while (true) {
			answer = deleteRepetition(cryptogram);
			cryptogram = answer;

			if (isRepetitive(cryptogram) == 0) {
				return answer;
			}
		}
	}

	// 연속하는 중복 문자를 제거하는 메소드
	private static String deleteRepetition(String cryptogram) {
		StringBuilder sb = new StringBuilder();

		if (cryptogram.charAt(0) != cryptogram.charAt(1)) { // 첫번째 인덱스 문자 중복 확인
			sb.append(cryptogram.charAt(0));
		}

		for (int i = 1; i < cryptogram.length() - 1; i++) { // 문자열의 첫번째와 마지막 인덱스를 제외한 문자의 중복 확인

			if (cryptogram.charAt(i) != cryptogram.charAt(i - 1) && cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
				sb.append(cryptogram.charAt(i));
			}
		}

		if (cryptogram.charAt(lastIndexOf(cryptogram)) != (cryptogram.charAt(
			lastIndexOf(cryptogram) - 1))) { // 마지막 인덱스 문자 중복 확인
			sb.append(cryptogram.charAt(cryptogram.length() - 1));
		}

		return sb.toString();
	}

	// 매개변수의 마지막 인덱스를 반환하는 메소드
	private static int lastIndexOf(String cryptogram) {
		return cryptogram.length() - 1;
	}

	// 연속하는 중복 문자가 있는지 확인하는 메소드
	private static int isRepetitive(String cryptogram) {
		for (int i = 0; i < cryptogram.length() - 1; i++) {
			if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
				return 1;
			}
		}

		return 0;
	}

}
