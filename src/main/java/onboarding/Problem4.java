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

    public static String solution(String word) {
        String answer = "";
		return answer;
    }
}
