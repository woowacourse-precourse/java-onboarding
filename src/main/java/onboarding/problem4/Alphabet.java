package onboarding.problem4;

import static java.lang.Character.*;

public class Alphabet {

	private static final char ALPHABET_CAPITAL_A = 'A';
	private static final char ALPHABET_SMALL_A = 'a';
	private static final int ALPHABET_COUNT = 26;
	private static final int ALPHABETIC_ORDER_Z = 'z' - 'a';

	private final char character;

	public Alphabet(char character) {
		this.character = character;
	}

	public char getFlipped() {
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
