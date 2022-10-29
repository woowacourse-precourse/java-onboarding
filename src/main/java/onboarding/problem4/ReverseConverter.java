package onboarding.problem4;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseConverter {
	public static final Map<Character, Character> ALPHABET_AND_REVERSE_MAP = IntStream.rangeClosed(0, 25)
		.boxed()
		.collect(Collectors.toMap(index -> (char)('A' + index), index -> (char)('Z' - index)));

	public static Character convert(Character character) {
		if (Character.isUpperCase(character)) {
			return ALPHABET_AND_REVERSE_MAP.get(character);
		} else {
			char characterToUpperCase = Character.toUpperCase(character);
			return Character.toLowerCase(ALPHABET_AND_REVERSE_MAP.get(characterToUpperCase));
		}
	}

	public static String convert(String word) {
		StringBuilder result = new StringBuilder();
		for (char c : word.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				result.append(convert(c));
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}
}
