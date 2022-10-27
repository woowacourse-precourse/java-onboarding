package onboarding;

public class Problem2 {

	public static String solution(String cryptogram) {
		char tmp = cryptogram.charAt(0);
		int continuationLength = 0;
		for (int i = 0; i < cryptogram.length(); i++) {
			if (tmp == cryptogram.charAt(i)) {
				continuationLength++;
			} else {
				tmp = cryptogram.charAt(i);
				continuationLength = 1;
			}
			if (continuationLength == 2) {
				int start = i - continuationLength + 1;
				cryptogram = cryptogram.substring(0, start) + cryptogram.substring(i + 1);
				continuationLength = 0;
				i = -1;
			}
		}
		return cryptogram;
	}

}
