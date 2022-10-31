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
	public static String solution(String word) {
		Hashtable<Character, Character> ht = initHashTable();
		return ("");
	}
}
