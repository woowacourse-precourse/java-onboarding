package onboarding;

import java.util.Hashtable;

public class Problem4 {
	private static Hashtable<Character, Character> initHashTable() {
		Hashtable<Character, Character> ht = new Hashtable<>();

		for (int i = 0; i < 26; i++) {
			ht.put((char)(i + 97), (char)(122 - i));
			ht.put((char)(i + 65), (char)(90 - i));
		}
		return (ht);
	}
	private static char convertCharacter(char from, Character to) {
		if (to == null)
			return (from);
		return (to);
	}
	public static String solution(String word) {
		Hashtable<Character, Character> ht = initHashTable();
		StringBuilder sb = new StringBuilder();
		int len = word.length();
		char current;

		for (int i = 0; i < len; i++) {
			current = word.charAt(i);
			sb.append(convertCharacter(current, ht.get(current)));
		}
		return (sb.toString());
	}
}
