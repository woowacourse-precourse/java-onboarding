package onboarding.problem4;

import java.util.Optional;

public class FrogDictionary {

	private static final int ALPHABETIC_ORDER_Z = 'z' - 'a';
	private static final int ALPHABET_COUNT = 26;
	private static final char ALPHABET_SMALL_A = 'a';

	public Optional<Character> find(char character) {
		if (isAlphabetic(character)) {
			return Optional.of(convert(character));
		}
		return Optional.empty();
	}

	private boolean isAlphabetic(char character) {
		return Character.isAlphabetic(character);
	}

	private char convert(char character) {
		if (Character.isUpperCase(character)) {
			return Character.toUpperCase(flipAlphabet(character));
		}
		return flipAlphabet(character);
	}

	private char flipAlphabet(char character) {
		int alphabeticOrder = getAlphabeticOrderOf(character);
		int flippedOrder = (ALPHABETIC_ORDER_Z - alphabeticOrder) % ALPHABET_COUNT;
		return (char)(ALPHABET_SMALL_A + flippedOrder);
	}

	private int getAlphabeticOrderOf(char character) {
		return Character.toLowerCase(character) - ALPHABET_SMALL_A;
	}
}