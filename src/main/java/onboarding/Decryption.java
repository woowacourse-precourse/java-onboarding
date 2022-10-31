package onboarding;

public class Decryption {
	private static final int MAX_INPUT_LENGTH = 1000;
	private static final int MIN_INPUT_LENGTH = 1;

	private final String cryptogram;

	public Decryption(String cryptogram) {
		validateInput(cryptogram);
		this.cryptogram = cryptogram;
	}

	private void validateInput(String cryptogram) {
		validateInputLength(cryptogram);
		validateLowerCase(cryptogram);
	}

	private void validateInputLength(String cryptogram) {
		if (cryptogram.length() > MAX_INPUT_LENGTH || cryptogram.length() < MIN_INPUT_LENGTH) {
			throw new IllegalArgumentException("암호문의 길이는 1이상 100이하 입니다.");
		}
	}

	private void validateLowerCase(String cryptogram) {
		if (!StringPatterUtils.isFormedLowerCase(cryptogram)) {
			throw new IllegalArgumentException("암호문은 알파벳 소문자로만 이루어져야 합니다.");
		}
	}
}
