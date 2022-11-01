package onboarding.problem7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private static final String USER_ID_PATTERN = "^[a-z]{1,30}";
	private final String userId;

	public User(String userId) {
		if (!validateUserId(userId)) {
			throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로 구성된 1 이상 30 이하인 문자열입니다.");
		}
		this.userId = userId;
	}

	private boolean validateUserId(String userId) {
		Pattern compile = Pattern.compile(USER_ID_PATTERN);
		Matcher matcher = compile.matcher(userId);
		return matcher.matches();
	}

}
