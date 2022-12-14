package onboarding;

import static onboarding.enums.problem4.AlphabetAscii.*;
import static onboarding.enums.problem4.Index.*;

import java.util.*;

public class Problem4 {
	public static final String INIT_NULL = "";
	public static Map<Character, Character> frogDictionary;
	public static List<Character> motherWord;

	public static String solution(String word) {
		init();
		makeFrogDictionary();
		separateLetter(word);

		return reverseWord();
	}

	public static void init() {
		frogDictionary = new HashMap<>();
		motherWord = new ArrayList<>();
	}

	public static String reverseWord() {
		String reverseResult = INIT_NULL;

		for (Character letter : motherWord) {
			reverseResult += (isAlphabet((int)letter)) ? frogDictionary.get(letter) : letter;
		}
		return reverseResult;
	}

	public static boolean isAlphabet(int letterToInt) {
		if (letterToInt >= A.getNumber() && letterToInt <= z.getNumber()) {
			return true;
		}
		return false;
	}

	public static void separateLetter(String word) {
		String[] letters = word.split("");

		for (String letter : letters) {
			addMotherLetter(letter.charAt(0));
		}
	}

	public static void addMotherLetter(char letter) {
		motherWord.add(letter);
	}

	public static void makeFrogDictionary() {
		for (int index = INDEX_START.getIndex(); index < INDEX_END.getIndex(); index++) {
			addLowerCase(index);
			addUpperCase(index);
		}
	}

	public static void addUpperCase(int index) {
		frogDictionary.put((char)(A.getNumber() + index), (char)(Z.getNumber() - index));
	}

	public static void addLowerCase(int index) {
		frogDictionary.put((char)(a.getNumber() + index), (char)(z.getNumber() - index));
	}
}
