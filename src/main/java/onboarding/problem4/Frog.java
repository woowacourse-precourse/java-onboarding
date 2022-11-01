package onboarding.problem4;

public class Frog {

	private static final int MAX_WORD_LENGTH = 1000;
	private static final int MIN_WORD_LENGTH = 1;
	private final String word;

	public Frog(String word) {
		validateWordLength(word);
		this.word = word;
	}

	private void validateWordLength(String word) {
		if (word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH) {
			throw new IllegalArgumentException("문자열의 길이는 1~1000이어야 합니다.");
		}
	}

	public String speak() {
		StringBuilder stringBuilder = new StringBuilder();
		char[] words = word.toCharArray();
		for (char w : words) {
			stringBuilder.append(FrogDictionary.convert(w));
		}
		return stringBuilder.toString();
	}
}
