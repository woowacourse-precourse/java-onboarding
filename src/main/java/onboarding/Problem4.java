package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

	public static char createReversedCharacter(char alphabet) {
		if (Character.isUpperCase(alphabet)) {
			return (char) ('Z' - alphabet + 'A');
		}
		if (Character.isLowerCase(alphabet)) {
			return (char) ('z' - alphabet + 'a');
		}
		return alphabet;
	}

    public static String solution(String word) {
        String answer = "";

		for (char alphabet : word.toCharArray()) {
			answer += createReversedCharacter(alphabet);
		}

		return answer;
    }
}
