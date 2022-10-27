package onboarding.problem4;

import static java.lang.Character.*;

public class Alphabet {

	private static final char ALPHABET_CAPITAL_A = 'A';
	private static final char ALPHABET_SMALL_A = 'a';
	private static final int ALPHABET_COUNT = 26;
	private static final int ALPHABETIC_ORDER_Z = 'z' - 'a';

	private final char character;

	public Alphabet(char character) {
		validateAlphabetic(character);
		this.character = character;
	}

	public char getFlipped() {
		int flippedAlphabeticOrder = flipAlphabeticOrder(getAlphabeticOrderOf(character));
		if (isUpperCase(character)) {
			return castCodePoint(ALPHABET_CAPITAL_A + flippedAlphabeticOrder);
		}
		return castCodePoint(ALPHABET_SMALL_A + flippedAlphabeticOrder);
	}

	private int flipAlphabeticOrder(int alphabeticOrder) {
		return (ALPHABETIC_ORDER_Z - alphabeticOrder) % ALPHABET_COUNT;
	}

	private int getAlphabeticOrderOf(char character) {
		return toLowerCase(character) - ALPHABET_SMALL_A;
	}

	private char castCodePoint(int codePoint) {
		return (char)codePoint;
	}

	private void validateAlphabetic(char character) {
		if (!isAlphabetic(character)) {
			throw new IllegalArgumentException("알파벳이 아닌 문자로 알파벳을 생성했습니다");
		}
	}
}
