package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
	private static final int ALPHABET_COUNT = 26;

	public static String solution(String word) {
		Map<Character, Character> wordDictionary = createWordDictionary();
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {
			if (!isAlphabet(word.charAt(i), wordDictionary)) {
				answer.append(word.charAt(i));
				continue;
			}
			answer.append(getAlphabetFromWordDictionary(word.charAt(i), wordDictionary));
		}
		return answer.toString();
	}

	private static Map<Character, Character> createWordDictionary() {
		Map<Character, Character> wordDictionary = new HashMap<>(ALPHABET_COUNT);

		for (int i = 0; i < ALPHABET_COUNT; i++) {
			putAlphabetPairInWordDictionary(wordDictionary, i);
		}
		return wordDictionary;
	}

	private static void putAlphabetPairInWordDictionary(Map<Character, Character> wordDictionary, int i) {
		wordDictionary.put((char)('a' + i), (char)('z' - i));
		wordDictionary.put((char)('A' + i), (char)('Z' - i));
	}

	private static boolean isAlphabet(char word, Map<Character, Character> wordDictionary) {
		return wordDictionary.containsKey(word);
	}

	private static Character getAlphabetFromWordDictionary(char word, Map<Character, Character> wordDictionary) {
		return wordDictionary.get(word);
	}
}
