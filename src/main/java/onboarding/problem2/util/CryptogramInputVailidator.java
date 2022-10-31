package onboarding.problem2.util;

import java.util.regex.Pattern;

public class CryptogramInputVailidator {
	private static Pattern alphabetLowcasePattern = Pattern.compile("^[a-z]*$");
	public static boolean lengthValidator(String cryptogram) {
		return cryptogram.length() >= 1 && cryptogram.length() <= 1000;
	}

	public static boolean alphabetLowcasePattern(String cryptogram) {
		return alphabetLowcasePattern.matcher(cryptogram).find();
	}
}
