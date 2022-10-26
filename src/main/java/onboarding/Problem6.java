package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
	private static final String DOMAIN = "@email.com";

	public static boolean isValidInput(String email, String nickName) {
		if (11 > email.length() || email.length() >= 20) {
			return false;
		} else if (1 > nickName.length() || nickName.length() >= 20) {
			return false;
		} else if (!email.endsWith(DOMAIN)) {
			return false;
		}
		return true;
	}

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		return answer;
	}
}
