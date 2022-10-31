package onboarding.problem2;

import java.util.regex.Pattern;

public class CryptogramTypeValidator {
	private final Pattern cryptogramPattern = Pattern.compile("^[a-z]*$");
	public boolean validate(String cryptogram) {
		return cryptogramPattern.matcher(cryptogram).matches();
	}
}
