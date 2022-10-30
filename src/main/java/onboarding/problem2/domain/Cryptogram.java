package onboarding.problem2.domain;

public class Cryptogram {

	private final String cryptogram;

	public Cryptogram(String cryptogram) {
		this.cryptogram = cryptogram;
	}

	public char[] toCharArray() {
		return cryptogram.toCharArray();
	}

	public int length() {
		return cryptogram.length();
	}
}
