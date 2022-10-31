package onboarding.problemfour.domain;

import java.util.HashMap;

public class Frog {

	private HashMap<Character, Character> dictionary = new HashMap<>();

	public Frog() {
		makeDictionary();
	}

	private void makeDictionary() {
		for (int i = 0; i < 26; i++) {
			dictionary.put((char)('A' + i), (char)('Z' - i));
			dictionary.put((char)('a' + i), (char)('z' - i));
		}
	}

	public String convert(String word) {

		String result = "";

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (dictionary.containsKey(ch)) {
				result += dictionary.get(ch);
			} else if (!dictionary.containsKey(ch)) {
				result += ch;
			}
		}

		return result;
	}
}
