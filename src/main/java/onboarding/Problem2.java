package onboarding;

public class Problem2 {
	public static boolean[] isConsecutive;

	public static String solution(String cryptogram) {
		while (isDeletable(cryptogram)) {
			cryptogram = deleteConsecutive(cryptogram);
		}
		return cryptogram;
	}

	public static boolean isDeletable(String cryptogram) {
		isConsecutive = new boolean[cryptogram.length()];
		boolean deletable = false;
		for (int i = 0; i < cryptogram.length() - 1; i++) {
			if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
				isConsecutive[i] = true;
				isConsecutive[i + 1] = true;
				deletable = true;
			}
		}
		return deletable;
	}

	public static String deleteConsecutive(String cryptogram) {
		
		return cryptogram;
	}

}
