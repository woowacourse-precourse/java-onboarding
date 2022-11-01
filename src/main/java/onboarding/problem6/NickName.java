package onboarding.problem6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NickName {
	private static final String NICK_NAME_PATTERN = "^[가-힣]{1,19}";
	private final String nickName;

	public NickName(String inputNickName) {
		if (!isValidateNickName(inputNickName)) {
			throw new IllegalArgumentException("닉네임은 한글로만 1자 이상 20자 미만이어야합니다.");
		}
		this.nickName = inputNickName;
	}

	boolean isValidateNickName(String inputNickName) {
		Pattern compile = Pattern.compile(NICK_NAME_PATTERN);
		Matcher matcher = compile.matcher(inputNickName);
		return matcher.matches();
	}

	public String getNickName() {
		return nickName;
	}
}
