package onboarding.problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordConverter {
	public static final int ASCII_OF_LOWERCASE_A = 97;
	public static final int ASCII_OF_LOWERCASE_Z = 122;
	public static final int ASCII_OF_UPPERCASE_A = 65;
	public static final int ASCII_OF_UPPERCASE_Z = 90;

	private enum CharacterCategory {
		LOWERCASE, UPPERCASE, NOT_ALPHABET
	}

	public static String convertWord(String word) {
		List<Character> convertedWordList = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			char oneCharacter = word.charAt(i);
			if (checkCharacterCategory(oneCharacter) == CharacterCategory.LOWERCASE) {
				convertedWordList.add(convertLowerCharacter(oneCharacter));
			} else if (checkCharacterCategory(oneCharacter) == CharacterCategory.UPPERCASE) {
				convertedWordList.add(convertUpperCharacter(oneCharacter));
			} else {
				convertedWordList.add(oneCharacter);
			}
		}

		String convertedWord = convertedWordList.stream().map(String::valueOf).collect(Collectors.joining());

		return convertedWord;
	}

	public static CharacterCategory checkCharacterCategory(char oneCharacter) {
		if (ASCII_OF_LOWERCASE_A <= oneCharacter && oneCharacter <= ASCII_OF_LOWERCASE_Z) {
			return CharacterCategory.LOWERCASE;
		} else if (ASCII_OF_UPPERCASE_A <= oneCharacter && oneCharacter <= ASCII_OF_UPPERCASE_Z) {
			return CharacterCategory.UPPERCASE;
		} else {
			return CharacterCategory.NOT_ALPHABET;
		}
	}

	public static char convertLowerCharacter(char lowercaseCharacter) {
		int convertedCharacter = lowercaseCharacter;

		convertedCharacter = convertedCharacter + ((109 - convertedCharacter)*2 + 1);

		return (char)convertedCharacter;
	}

	public static char convertUpperCharacter(char uppercaseCharacter) {
		int convertedCharacter = uppercaseCharacter;

		convertedCharacter = convertedCharacter + ((77 - convertedCharacter)*2 + 1);

		return (char)convertedCharacter;
	}
}
