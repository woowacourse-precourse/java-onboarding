package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		char[] cryptogramArray = cryptogram.toCharArray();

		int outputIndex = 1;
		char checkingChar = cryptogramArray[0];
		for (int i = 1; i < cryptogramArray.length; i++) {
			if (outputIndex > 0 && cryptogramArray[i] == cryptogramArray[outputIndex - 1]) {
				checkingChar = cryptogramArray[outputIndex - 1];
				while (outputIndex > 0 && cryptogramArray[outputIndex - 1] == checkingChar) {
					outputIndex--;
				}
			} else if (cryptogramArray[i] == checkingChar) {
			} else {
				cryptogramArray[outputIndex++] = cryptogramArray[i];
			}
		}

		return new String(cryptogramArray, 0, outputIndex);
	}
}
