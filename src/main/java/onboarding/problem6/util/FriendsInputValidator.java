package onboarding.problem6.util;

import java.util.List;
import java.util.regex.Pattern;

public class FriendsInputValidator {
	public static boolean sizeValidator(List<List<String>> forms) {
		boolean result = forms.size() >= 1 && forms.size() <= 10_000;
		if (!result) throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하입니다.");
		return result;
	}

	public static boolean emailValidator(List<List<String>> forms) {
		boolean result = true;
		final Pattern emailPattern = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
		final Pattern emailPatternDomain = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com$");
		for (List<String> listFriend : forms) {
			String email = listFriend.get(0);
			if (!(emailPattern.matcher(email).matches() && emailPatternDomain.matcher(email).matches() && (email.length() >= 11 && email.length() < 20))) {
				result = false;
				break;
			}

		}

		if (!result) throw new IllegalArgumentException("이메일 형식은 11자 이상 20자 미만이며 email.com도메인만 허용합니다.");
		return result;
	}

	public static boolean nicknameValidator(List<List<String>> forms) {
		boolean result = true;
		for (List<String> listFriend : forms) {
			String nickname = listFriend.get(1);
			if (!(Pattern.matches("^[ㄱ-ㅎ가-힣]*$", nickname) && (nickname.length() >= 1 && nickname.length() < 20))) {
				result = false;
				break;
			}

		}

		if (!result) throw new IllegalArgumentException("닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만입니다.");
		return result;
	}
}
