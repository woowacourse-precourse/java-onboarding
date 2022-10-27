package onboarding;

public class Problem2 {

	public static String solution(String cryptogram) {
		String answer = "answer";

		try {
			while (true) {
				String nextCryptogram = eraseDuplicateCharacter(cryptogram);
				if (nextCryptogram.compareTo(cryptogram) == 0) {
					answer = cryptogram;
					break;
				} else {
					cryptogram = nextCryptogram;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("cryptogram이 null입니다.");
		}

		return answer;
	}


	/**
	 * 기능 1 문자열에서 중복된 문자를 제거하는 기능
	 * @param str
	 * @return erasedDuplicateCharacter
	 */
	public static String eraseDuplicateCharacter(String str) {

		if (str.length() == 1 || str.length() == 0) { // 반복될 문자가 없는 경우 바로 리턴
			return str;
		}

		String erasedDuplicateCharacter = ""; // 중복을 제거한 문자열

		if (str.charAt(0) != str.charAt(1)) { // 첫번째 문자는 중복될 경우의 수가 두번째 문자와 중복되는 경우 밖에 없다.
			erasedDuplicateCharacter += str.charAt(0);
		}
		for (int i = 1; i < str.length() - 1; i++) { // 첫번째 문자와 마지막 문자를 제외한 문자의 중복 체크
			if (str.charAt(i) != str.charAt(i - 1) && str.charAt(i) != str.charAt(i + 1)) {
				erasedDuplicateCharacter += str.charAt(i); // 앞, 뒤 문자를 체크 했을때, 중복이 없는 경우
			}
		}
		if (str.charAt(str.length() - 1) != str.charAt(
			str.length() - 2)) { // 마지막 문자는 마지막 바로 앞의 문자와 비교한다.
			erasedDuplicateCharacter += str.charAt(str.length() - 1);
		}

		return erasedDuplicateCharacter;
	}

}
