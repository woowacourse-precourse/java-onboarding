package onboarding;

public class Problem2 {

	public static String solution(String cryptogram) {
		return Decryptor.decrypt(cryptogram);
	}

	public static class Decryptor {

		public static String decrypt(String cryptogram) {
			final StringBuilder builder = new StringBuilder(cryptogram.length());
			for (int i = 0; i < cryptogram.length(); i++) {
				char cur = cryptogram.charAt(i);
				int count = 0;
				while (i + 1 < cryptogram.length() && cur == cryptogram.charAt(i + 1)) {
					i++;
					count++;
				}
				if (count == 0) {
					builder.append(cryptogram.charAt(i));
				}
			}

			final String plainText = builder.toString();
			if (cryptogram.length() == plainText.length()) {
				return plainText;
			} else {
				return decrypt(plainText);
			}
		}

	}

}
