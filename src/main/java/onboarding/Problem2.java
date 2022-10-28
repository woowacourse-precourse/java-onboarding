package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		while (isDeletable(cryptogram)) {
			cryptogram = deleteConsecutive(cryptogram);
		}
		return cryptogram;
	}

	public static boolean isDeletable(String cryptogram) {
		return false;
	}

	public static String deleteConsecutive(String cryptogram) {
		return cryptogram;
	}

}
