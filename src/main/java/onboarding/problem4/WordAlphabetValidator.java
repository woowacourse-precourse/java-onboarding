package onboarding.problem4;

import java.util.regex.Pattern;

public class WordAlphabetValidator {
	private final Pattern pattern = Pattern.compile("[a-z|A-Z]");

	public boolean validate(Character word) {
		return pattern.matcher(word.toString()).matches();
	}

}
