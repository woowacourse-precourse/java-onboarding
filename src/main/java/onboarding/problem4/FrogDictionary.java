package onboarding.problem4;

import static java.lang.Character.*;

import java.util.Optional;

public class FrogDictionary {

	public Optional<Character> find(char character) {
		if (isAlphabetic(character)) {
			return Optional.of(flip(character));
		}
		return Optional.empty();
	}

	private char flip(char character) {
		Alphabet alphabet = new Alphabet(character);
		return alphabet.getFlipped();
	}
}