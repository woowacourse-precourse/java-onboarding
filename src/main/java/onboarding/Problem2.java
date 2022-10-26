package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		int ptr1 = 0;
		int ptr2 = 1;
		while (ptr2 < cryptogram.length()) {
			if (cryptogram.charAt(ptr1) == cryptogram.charAt(ptr2)) {
				cryptogram = cryptogram.substring(0, ptr1) + cryptogram.substring(ptr2 + 1);
				ptr1 = 0;
				ptr2 = 1;
				continue;
			}
			ptr1++;
			ptr2++;
		}

		return cryptogram;
	}
}
