package onboarding.problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import onboarding.problem4.exception.CharacterCategoryMismatchException;

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
			CharacterCategory characterCategory = checkCharacterCategory(oneCharacter);
			if (characterCategory == CharacterCategory.LOWERCASE) {
				convertedWordList.add(convertLowerCharacter(oneCharacter));
			} else if (characterCategory == CharacterCategory.UPPERCASE) {
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
		try {
			if (lowercaseCharacter < ASCII_OF_LOWERCASE_A || ASCII_OF_LOWERCASE_Z < lowercaseCharacter) {
				throw new CharacterCategoryMismatchException("The character is NOT LOWERCASE. Or not alphabet");
			}

			int convertedCharacter = lowercaseCharacter;

			convertedCharacter = convertedCharacter + ((109 - convertedCharacter)*2 + 1);

			return (char)convertedCharacter;

		} catch (CharacterCategoryMismatchException e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}

	public static char convertUpperCharacter(char uppercaseCharacter) {
		try {
			if (uppercaseCharacter < ASCII_OF_UPPERCASE_A || ASCII_OF_UPPERCASE_Z < uppercaseCharacter) {
				throw new CharacterCategoryMismatchException("The character is NOT UPPERCASE. Or not alphabet");
			}

			int convertedCharacter = uppercaseCharacter;

			convertedCharacter = convertedCharacter + ((77 - convertedCharacter)*2 + 1);

			return (char)convertedCharacter;

		} catch (CharacterCategoryMismatchException e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}
}
