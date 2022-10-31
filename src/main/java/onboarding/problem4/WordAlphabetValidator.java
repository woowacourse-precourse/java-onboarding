package onboarding.problem4;

import java.util.regex.Pattern;

public class WordAlphabetValidator {
	private final Pattern pattern = Pattern.compile("[a-z|A-Z]");

	public boolean validate(Character character) {
		return pattern.matcher(character.toString()).matches();
	}

}
