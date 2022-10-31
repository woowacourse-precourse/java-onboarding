package onboarding.problem2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

	private static final String REGEX = "(([a-z])\\2+)";

	private final Pattern pattern;

	public Decoder() {
		this.pattern = Pattern.compile(REGEX);
	}

	public String decode(String cryptogram) {
		validateCryptogram(cryptogram);

		while (hasDuplicates(cryptogram)) {
			cryptogram = deleteDuplicates(cryptogram);
		}
		return cryptogram;
	}

	private boolean hasDuplicates(String cryptogram) {
		Matcher matcher = pattern.matcher(cryptogram);
		return matcher.find();
	}

	private String deleteDuplicates(String cryptogram) {
		return cryptogram.replaceAll(REGEX, "");
	}

	private void validateCryptogram(String cryptogram) {
		if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
			throw new RuntimeException("cryptogram 은 1 이상 1000 미만의 길이만 사용 가능합니다.");
		} else if (!cryptogram.matches("^[a-z]*$")) {
			throw new RuntimeException("cryptogram 은 소문자만 사용 가능합니다.");
		}
	}
}
