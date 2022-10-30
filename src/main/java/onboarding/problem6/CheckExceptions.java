package onboarding.problem6;

import java.util.List;
import java.util.regex.Pattern;

import onboarding.problem6.exception.FormatUnfitException;
import onboarding.problem6.exception.SizeOutOfRangeException;

public class CheckExceptions {
	public static void throwAllExceptions(List<List<String>> forms) throws Exception {
		throwFormsException(forms.size());

		for (List<String> oneCrew : forms) {
			throwEmailException(oneCrew.get(0));
			throwNicknameException(oneCrew.get(1));
		}
	}

	public static boolean checkAllExceptions(List<List<String>> forms) {
		if (checkFormsException(forms.size()) == false) {
			return false;
		}

		for (List<String> oneCrew : forms) {
			if (checkEmailException(oneCrew.get(0)) == false) {
				return false;
			}

			if (checkNicknameException(oneCrew.get(1)) == false) {
				return false;
			}
		}

		return true;
	}

	public static void throwFormsException(int formSize) throws Exception {
		if (formSize < 1 || 10000 < formSize) {
			throw new SizeOutOfRangeException("Form size is out of range.");
		}
	}

	public static boolean checkFormsException(int formSize) {
		if (formSize < 1 || 10000 < formSize) {
			return false;
		}

		return true;
	}

	public static void throwNicknameException(String nickname) throws Exception {
		int nicknameLength = nickname.length();

		if (nicknameLength < 1 || 20 <= nicknameLength) {
			throw new SizeOutOfRangeException("Nickname length is out of range.");
		}

		if (Pattern.matches("^[ㄱ-ㅎ가-힣]*$", nickname) == false) {
			throw new FormatUnfitException("Nickname format is not fit.");
		}
	}

	public static boolean checkNicknameException(String nickname) {
		int nicknameLength = nickname.length();

		if (nicknameLength < 1 || 20 <= nicknameLength) {
			return false;
		}

		if (Pattern.matches("^[ㄱ-ㅎ가-힣]*$", nickname) == false) {
			return false;
		}

		return true;
	}

	public static void throwEmailException(String email) throws Exception {
		int emailLength = email.length();

		if (emailLength < 11 || 20 <= emailLength) {
			throw new SizeOutOfRangeException("Email length is out of range.");
		}

		if (email.contains("@email.com") == false) {
			throw new FormatUnfitException("Email format is not fit.");
		}
	}

	public static boolean checkEmailException(String email) {
		int emailLength = email.length();

		if (emailLength < 11 || 20 <= emailLength) {
			return false;
		}

		if (email.contains("@email.com") == false) {
			return false;
		}

		return true;
	}

}
