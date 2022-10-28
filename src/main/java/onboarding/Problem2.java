package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		char [] cryptogramArray = cryptogram.toCharArray();

		int outputIndex = 1;
		for (int i = 1; i < cryptogramArray.length; i++) {
			if (outputIndex > 0 && cryptogramArray[i] == cryptogramArray[outputIndex - 1]) {
				outputIndex--;
			}  else {
				cryptogramArray[outputIndex++] = cryptogramArray[i];
			}
		}

		return new String(cryptogramArray, 0, outputIndex);
	}
}
