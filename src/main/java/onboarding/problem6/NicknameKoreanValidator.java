package onboarding.problem6;

import java.util.regex.Pattern;

public class NicknameKoreanValidator {
	Pattern koreanPattern = Pattern.compile("^[ㄱ-ㅎ가-힣]*$");

	public boolean validateAllKorean(String nickName) {
		return koreanPattern.matcher(nickName).matches();
	}
}
