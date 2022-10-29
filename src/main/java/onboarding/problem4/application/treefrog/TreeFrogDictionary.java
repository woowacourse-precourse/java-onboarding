package onboarding.problem4.application.treefrog;

import static onboarding.problem4.Problem4Constant.*;

import java.util.HashMap;
import java.util.Map;

import onboarding.problem4.application.Dictionary;

public class TreeFrogDictionary implements Dictionary {

	private final Map<Character, Character> dictionary;

	public TreeFrogDictionary() {
		dictionary = new HashMap<>();
		setTreeFrogDictionary();
	}

	@Override
	public Map<Character, Character> getDictionary() {
		return dictionary;
	}

	private void setTreeFrogDictionary() {
		addCharAsCharUntil(ALPHABET_UPPER_START, ALPHABET_UPPER_END, ALPHABET_LENGTH);
		addCharAsCharUntil(ALPHABET_LOWER_START, ALPHABET_LOWER_END, ALPHABET_LENGTH);
	}

	private void addCharAsCharUntil(char from, char to, int range) {
		for (int i = 0; i < range; i++) {
			dictionary.put((char)(from + i), (char)(to - i));
		}
	}
}
