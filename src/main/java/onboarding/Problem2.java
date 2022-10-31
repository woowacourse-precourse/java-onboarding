package onboarding;

import onboarding.problem2.CryptogramTranslation;
import onboarding.problem2.CryptogramValidator;

public class Problem2 {

	public static final String GUIDE = "cryptogram은 길이가 1 이상 1000 이하인 문자열이다.\n"
		+ "cryptogram은 알파벳 소문자로만 이루어져 있다.";

	public static String solution(String cryptogram) {
		CryptogramValidator cryptogramValidator = new CryptogramValidator();
		if (!cryptogramValidator.validate(cryptogram)) {
			throw new IllegalArgumentException(GUIDE);
		}
		CryptogramTranslation cryptogramTranslation = new CryptogramTranslation();
		return cryptogramTranslation.translate(cryptogram);
	}
}
