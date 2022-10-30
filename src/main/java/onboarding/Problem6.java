package onboarding;

import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
		return answer;
	}

	static class InputValidator {
		private final static String EMAIL_DOMAIN = "email.com";

		private static void isRightFormsRange(List<List<String>> forms) {
			int formsSize = forms.size();
			if (formsSize < 1 || formsSize > 10000) {
				throw new IllegalArgumentException();
			}
		}

		private static boolean isRightFormRange(List<String> form) {
			if (form.size() != 2) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		public static boolean isRightNickname(String nickname) {
			if (!isRightNicknameRange(nickname) || !hasNicknameKorean(nickname)) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean isRightNicknameRange(String nickname) {
			int nicknameLength = nickname.length();
			if (nicknameLength < 1 || nicknameLength > 20) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean hasNicknameKorean(String nickname) {
			if (nickname.matches("^[가-힣]*$")) {
				return true;
			}
			throw new IllegalArgumentException();
		}

		public static boolean isRightEmail(String email) {
			if (!isRightEmailRange(email) || !isRightEmailFormat(email)) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean isRightEmailRange(String email) {
			if (email.length() < 11 || email.length() > 20) {
				throw new IllegalArgumentException();
			}
			return true;
		}

		private static boolean isRightEmailFormat(String email) {
			if (email.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@" + EMAIL_DOMAIN)) {
				return true;
			}
			throw new IllegalArgumentException();
		}
	}
}
