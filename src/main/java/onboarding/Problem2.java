package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		char[] cryptogramArray = cryptogram.toCharArray();
		while (checkContinuousSameLetter(cryptogramArray)) {
			cryptogramArray = removeContinuousSameLetter(cryptogramArray);
		}
		return new String(cryptogramArray).trim();
	}

	private static boolean checkContinuousSameLetter(char[] cryptogramArray) {
		for (int i = 1; i < cryptogramArray.length; i++) {
			if (cryptogramArray[i] == cryptogramArray[i - 1]) {
				return true;
			}
		}
		return false;
	}

	private static char[] removeContinuousSameLetter(char[] cryptogramArray) {
		int outputIndex = 1;
		char[] outputArray = new char[cryptogramArray.length];
		boolean isSameLetter = false;
		for (int i = 1; i < cryptogramArray.length; i++) {
			if (cryptogramArray[i] == cryptogramArray[i - 1]) {
				isSameLetter = true;
			} else {
				if (isSameLetter) {
					isSameLetter = false;
				} else {
					outputArray[outputIndex] = cryptogramArray[i - 1];
					outputIndex++;
				}
			}
		}
		if (!isSameLetter) {
			outputArray[outputIndex] = cryptogramArray[cryptogramArray.length - 1];
			outputIndex++;
		}
		char[] result = new char[outputIndex];
		System.arraycopy(outputArray, 0, result, 0, outputIndex);
		return result;
	}
}
