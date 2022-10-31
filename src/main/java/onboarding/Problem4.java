package onboarding;

import onboarding.problem4.AlphabetChanger;
import onboarding.problem4.WordAlphabetValidator;
import onboarding.problem4.WordsRangeValidator;

public class Problem4 {
	public static String solution(String word) {
		if (word.isBlank()) {
            throw new IllegalArgumentException("word는 null 혹은 공백으로 될수 없다.");
		}

		WordsRangeValidator wordsRangeValidator = new WordsRangeValidator();
		if (!wordsRangeValidator.validate(word.length())) {
			throw new IllegalArgumentException("word의 길이는 1이상 1,000 이하인 문자열이여야 한다.");
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
