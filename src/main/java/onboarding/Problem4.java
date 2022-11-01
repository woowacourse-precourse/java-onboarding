package onboarding;

public class Problem4 {
	private static final int TOTAL_ALPHABET_CNT = 25;
	private static final char LOWERCASE_BASE_CHAR = 'a';
	private static final char UPPERCASE_BASE_CHAR = 'A';

	public static String solution(String word) {
		String answer = convertTextToOpposite(word);
		return answer;
	}

	public static char convertCharacterToOpposite(char letter) {
		if (Character.isLowerCase(letter)) {
			int letterSeqOfAlphabet = letter - LOWERCASE_BASE_CHAR;
			int opposedLetterSeq = TOTAL_ALPHABET_CNT - letterSeqOfAlphabet;

			return (char) (opposedLetterSeq + LOWERCASE_BASE_CHAR);
		} else if (Character.isUpperCase(letter)) {
			int letterSeqOfAlphabet = letter - UPPERCASE_BASE_CHAR;
			int opposedLetterSeq = TOTAL_ALPHABET_CNT - letterSeqOfAlphabet;

			return (char) (opposedLetterSeq + UPPERCASE_BASE_CHAR);
		}

		return letter;
	}

	public static String convertTextToOpposite(String text) {
		return text.chars()
				.map(c -> convertCharacterToOpposite((char) c))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
}
