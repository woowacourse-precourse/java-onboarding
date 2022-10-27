package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

	public static Map<Character, Character> createFrogDictionary() {
		Map<Character, Character> frogDictionary = new HashMap<>();
		int tempNumber = 25;

		for(int i = 65; i < 91; i++) {
			frogDictionary.put((char)i, (char)(i + tempNumber));
			frogDictionary.put((char)(i + 32), (char)(i + 32 + tempNumber));
			tempNumber -= 2;
		}
		return frogDictionary;
	}

	public static String createReversedWord(String word, Map<Character, Character> frogDictionary){
		String reversedWord = "";

		for(int i =0; i<word.length(); i++) {
			if (frogDictionary.get(word.charAt(i)) != null) {
				reversedWord += frogDictionary.get(word.charAt(i));;
			}
			if (frogDictionary.get(word.charAt(i)) == null) {
				reversedWord += word.charAt(i);
			}
		}
		return reversedWord;
	}

    public static String solution(String word) {
        String answer = "";
		Map<Character, Character> frogDictionary = createFrogDictionary();

		answer = createReversedWord(word, frogDictionary);
		return answer;
    }
}
