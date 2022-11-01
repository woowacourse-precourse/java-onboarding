package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		while (checkContinuity(cryptogram.toCharArray())) {
			cryptogram = removeContinuity(cryptogram.toCharArray());
		}
		String answer = cryptogram;
		return answer;
	}

	public static boolean checkContinuity(char[] cryptogram) {
		char previousC = ' ';
		for (char c : cryptogram) {
			if (previousC == c) {
				return true;
			}
			previousC = c;
		}
		return false;
	}

	public static String removeContinuity(char[] cryptogram) {
		char previousC = ' ';
		boolean flag = false;
		String result = "";
		for (int i = 0; i < cryptogram.length; i++) {
			if (previousC == cryptogram[i]) {
				flag = true;
				continue;
			}

			if (!flag) {
				result += previousC;
			}

			previousC = cryptogram[i];
			flag = false;
		}
		if (!flag) {
			result += previousC;
		}

		return result;
	}
}
