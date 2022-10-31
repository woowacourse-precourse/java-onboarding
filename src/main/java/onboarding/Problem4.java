package onboarding;

import onboarding.problem4.AlphabetChanger;
import onboarding.problem4.WordAlphabetValidator;
import onboarding.problem4.WordsRangeValidator;

public class Problem4 {

	public static final String BASIC_GUIDE = "word는 null 혹은 공백으로 될수 없다.";
	public static final String TYPE_GUIDE = "word의 길이는 1이상 1,000 이하인 문자열이여야 한다.";

	public static String solution(String word) {
		if (word.isBlank()) {
            throw new IllegalArgumentException(BASIC_GUIDE);
		}

		WordsRangeValidator wordsRangeValidator = new WordsRangeValidator();
		if (!wordsRangeValidator.validate(word.length())) {
			throw new IllegalArgumentException(TYPE_GUIDE);
		}

		StringBuilder answer = new StringBuilder();

		AlphabetChanger alphabetChanger = new AlphabetChanger();
		WordAlphabetValidator wordAlphabetValidator = new WordAlphabetValidator();

		char[] characters = word.toCharArray();
		for (char character : characters) {
			if (wordAlphabetValidator.validate(character)) {
				character = alphabetChanger.change(character);
			}
			answer.append(character);
		}

		return answer.toString();
	}
}
