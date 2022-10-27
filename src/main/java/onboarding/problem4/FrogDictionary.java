package onboarding.problem4;

import static java.lang.Character.*;

import java.util.Optional;

public class FrogDictionary {

	private static final int ALPHABETIC_ORDER_Z = 'z' - 'a';
	private static final int ALPHABET_COUNT = 26;
	private static final char ALPHABET_SMALL_A = 'a';
	private static final char ALPHABET_CAPITAL_A = 'A';

	public Optional<Character> find(char character) {
		if (isAlphabetic(character)) {
			return Optional.of(convert(character));
		}
		return Optional.empty();
	}

	private char convert(char character) {
		int alphabeticOrder = getAlphabeticOrderOf(character);
		int flippedOrder = getFlippedAlphabeticOrder(alphabeticOrder);
		if (isUpperCase(character)) {
			return (char)(ALPHABET_CAPITAL_A + flippedOrder);
		}
		return (char)(ALPHABET_SMALL_A + flippedOrder);
	}

	private int getAlphabeticOrderOf(char character) {
		return toLowerCase(character) - ALPHABET_SMALL_A;
	}

	private int getFlippedAlphabeticOrder(int order) {
		return (ALPHABETIC_ORDER_Z - order) % ALPHABET_COUNT;
	}
}