package onboarding.problem2;

import onboarding.problem2.util.CryptogramInputVailidator;

public class SolveBrownCryptogram {
	public boolean isFailedInputValidation(String cryptogram) {
		if (!CryptogramInputVailidator.lengthValidator(cryptogram)) return true;
		if (!CryptogramInputVailidator.alphabetLowcasePattern(cryptogram)) return true;

		return false;
	}

	public String removeDuplicationSpelling(String cryptogram) {
		boolean isFindDuplicationSpelling = false;
		StringBuilder stringBuilder = new StringBuilder(cryptogram);
		for (int i = 0; i < cryptogram.length() - 1; i++) {
			if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
				stringBuilder.deleteCharAt(i);
				stringBuilder.deleteCharAt(i);
				isFindDuplicationSpelling = true;
				break;
			}
		}

		if (isFindDuplicationSpelling) return removeDuplicationSpelling(stringBuilder.toString());
		return stringBuilder.toString();
	}
}
