package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		StringBuilder cryptogramBuilder = stringToStringBuilder(cryptogram);
		addCharacterToVerifyEnd(cryptogramBuilder);

		boolean isSameWord = true;
		while (isSameWord) {
			isSameWord = findDuplicationInEntireString(cryptogramBuilder, false);
		}
		return cryptogramBuilder.toString().trim();
	}

	private static StringBuilder stringToStringBuilder(String cryptogram) {
		return new StringBuilder(cryptogram);
	}

	private static void addCharacterToVerifyEnd(StringBuilder cryptogramBuilder) {
		cryptogramBuilder.append(' ');
	}

	private static boolean findDuplicationInEntireString(StringBuilder cryptogramBuilder, boolean isSameWord) {
		for (int startIndex = 0; startIndex < cryptogramBuilder.length() - 1; startIndex++) {
			if (isCurrentSameWithNextWord(cryptogramBuilder.charAt(startIndex),
				cryptogramBuilder.charAt(startIndex + 1))) {

				isSameWord = true;
				deleteDuplicationInSpecificString(cryptogramBuilder, startIndex, startIndex + 2);
			}
		}
		return isSameWord;
	}

	private static boolean isCurrentSameWithNextWord(char currentWord, char nextWord) {
		return currentWord == nextWord;
	}

	private static void deleteDuplicationInSpecificString(StringBuilder cryptogramBuilder, int startIndex,
		int endIndex) {

		for (int j = startIndex + 1; j < cryptogramBuilder.length() - 1; j++) {
			if (!isCurrentSameWithNextWord(cryptogramBuilder.charAt(j), cryptogramBuilder.charAt(j + 1))) {
				cryptogramBuilder.delete(startIndex, endIndex);
				break;
			}
			endIndex++;
		}
	}
}
