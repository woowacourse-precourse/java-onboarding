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
	 * 기능 1 문자열에서 중복을 제거 하는 기능
	 */
	public static String eraseDuplicateCharacter(String str) {
		if (str.length() == 1 || str.length() == 0) {
			return str;
		}

		String ErasedDuplicateCharacter = "";

		if (str.charAt(0) != str.charAt(1)) {
			ErasedDuplicateCharacter += str.charAt(0);
		}
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i - 1) && str.charAt(i) != str.charAt(i + 1)) {
				ErasedDuplicateCharacter += str.charAt(i);
			}
		}
		if (str.charAt(str.length() - 1) != str.charAt(str.length() - 2)) {
			ErasedDuplicateCharacter += str.charAt(str.length() - 1);
		}

		return ErasedDuplicateCharacter;
	}


}
