package onboarding;

import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
		return answer;
	}

	static class InputValidator {

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
	}
}

