package onboarding.problem2;

public class CryptogramValidator {
	public boolean validate(String cryptogram) {
		CryptogramRangeValidator cryptogramRangeValidator = new CryptogramRangeValidator();
		CryptogramTypeValidator cryptogramTypeValidator = new CryptogramTypeValidator();
		return cryptogram != null
			&& cryptogramRangeValidator.validate(cryptogram.length())
			&& cryptogramTypeValidator.validate(cryptogram);
	}
}
