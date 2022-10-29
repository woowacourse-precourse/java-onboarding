package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		return removeDuplication(cryptogram);

	}

	private static String removeDuplication(String str) {
		char recent = 0;
		boolean isRemoved = false;
		for (int i = 0; i < str.length(); i++) {

			if (i > 0 && recent == str.charAt(i)) {
				str = str.substring(0, i - 1) + str.substring(i + 1);
				isRemoved = true;
				break;
			}
			recent = str.charAt(i);
		}
		if (isRemoved) {
			str = removeDuplication(str);
		}
		return str;
	}

}
