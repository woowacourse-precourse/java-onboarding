package onboarding.crytogramDecoding;

public class CryptogramDecoding {

	public CryptogramDecoding() {
	}

	public String decode(String originalCryptogram) {
		for (int i = 0; i < originalCryptogram.length(); i++) {
			for (int j = i + 1; j < originalCryptogram.length(); j++) {

			}
		}

		return "";
	}

	public void deleteCharacters(String cryptogram, int start, int finish) {
		cryptogram = cryptogram.substring(0, start) + cryptogram.substring(finish + 1);
	}
}
